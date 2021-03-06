package us.ihmc.euclid.geometry.tools;

import static us.ihmc.euclid.tools.EuclidCoreRandomTools.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import us.ihmc.euclid.geometry.BoundingBox2D;
import us.ihmc.euclid.geometry.BoundingBox3D;
import us.ihmc.euclid.geometry.Line3D;
import us.ihmc.euclid.geometry.LineSegment3D;
import us.ihmc.euclid.tuple2D.Point2D;
import us.ihmc.euclid.tuple2D.Vector2D;
import us.ihmc.euclid.tuple3D.Point3D;
import us.ihmc.euclid.tuple3D.Vector3D;

public abstract class EuclidGeometryRandomTools
{
   /**
    * Generates a random line 3D.
    * <p>
    * <ul>
    * <li>{@code point}<sub>i</sub> &in; [-1.0; 1.0].
    * <li>{@code direction}<sub>i</sub> &in; [-1.0; 1.0].
    * </ul>
    * </p>
    *
    * @param random the random generator to use.
    * @return the random line 3D.
    */
   public static Line3D generateRandomLine3D(Random random)
   {
      return new Line3D(generateRandomPoint3D(random), generateRandomVector3D(random));
   }

   /**
    * Generates a random line 3D.
    * <p>
    * <ul>
    * <li>{@code point}<sub>i</sub> &in; [-pointMinMax; pointMinMax].
    * <li>{@code direction}<sub>i</sub> &in; [-1.0; 1.0].
    * </ul>
    * </p>
    *
    * @param random the random generator to use.
    * @param pointMinMax the maximum absolute value for each coordinate of the line's point.
    * @return the random line 3D.
    * @throws RuntimeException if {@code pointMinMax < 0}.
    */
   public static Line3D generateRandomLine3D(Random random, double pointMinMax)
   {
      return new Line3D(generateRandomPoint3D(random, pointMinMax), generateRandomVector3D(random));
   }

   /**
    * Generates a random line segment 3D.
    * <p>
    * <ul>
    * <li>{@code firstEndpoint}<sub>i</sub> &in; [-1.0; 1.0].
    * <li>{@code secondEndpoint}<sub>i</sub> &in; [-1.0; 1.0].
    * </ul>
    * </p>
    *
    * @param random the random generator to use.
    * @return the random line segment 3D.
    */
   public static LineSegment3D generateRandomLineSegment3D(Random random)
   {
      return new LineSegment3D(generateRandomPoint3D(random), generateRandomPoint3D(random));
   }

   /**
    * Generates a random line segment 3D.
    * <p>
    * <ul>
    * <li>{@code firstEndpoint}<sub>i</sub> &in; [-minMax; minMax].
    * <li>{@code secondEndpoint}<sub>i</sub> &in; [-minMax; minMax].
    * </ul>
    * </p>
    *
    * @param random the random generator to use.
    * @param minMax the maximum absolute value for each coordinate of the line segment's endpoints.
    * @return the random line segment 3D.
    * @throws RuntimeException if {@code minMax < 0}.
    */
   public static LineSegment3D generateRandomLineSegment3D(Random random, double minMax)
   {
      return new LineSegment3D(generateRandomPoint3D(random, minMax), generateRandomPoint3D(random, minMax));
   }

   /**
    * Generates a random bounding box from random center location and random size.
    * 
    * @param random the random generator to use.
    * @param centerMinMax the maximum absolute value for each coordinate of the bounding box center.
    * @param sizeMax the maximum size along each axis for the bounding box.
    * @return the random bounding box.
    * @throws RuntimeException if {@code centerMinMax < 0} or {@code sizeMax < 0}.
    */
   public static BoundingBox2D generateRandomBoundingBox2D(Random random, double centerMinMax, double sizeMax)
   {
      Point2D center = generateRandomPoint2D(random, centerMinMax);
      Vector2D halfSize = generateRandomVector2D(random, 0.0, sizeMax / 2.0);
      return BoundingBox2D.createUsingCenterAndPlusMinusVector(center, halfSize);
   }

   /**
    * Generates a random bounding box from random center location and random size.
    * 
    * @param random the random generator to use.
    * @param centerMinMax the maximum absolute value for each coordinate of the bounding box center.
    * @param sizeMax the maximum size along each axis for the bounding box.
    * @return the random bounding box.
    * @throws RuntimeException if {@code centerMinMax < 0} or {@code sizeMax < 0}.
    */
   public static BoundingBox3D generateRandomBoundingBox3D(Random random, double centerMinMax, double sizeMax)
   {
      Point3D center = generateRandomPoint3D(random, centerMinMax);
      Vector3D halfSize = generateRandomVector3D(random, 0.0, sizeMax / 2.0);
      return BoundingBox3D.createUsingCenterAndPlusMinusVector(center, halfSize);
   }

   public static List<Point2D> generateRandomPointCloud2D(Random random, double centerMinMax, double minMax, int numberOfPoints)
   {
      List<Point2D> pointCloud2D = new ArrayList<>();

      Point2D center = generateRandomPoint2D(random, centerMinMax);
      for (int i = 0; i < numberOfPoints; i++)
      {
         Point2D point = generateRandomPoint2D(random, minMax);
         point.add(center);
         pointCloud2D.add(point);
      }

      return pointCloud2D;
   }

   public static List<Point2D> generateRandomCircleBasedConvexPolygon2D(Random random, double centerMinMax, double maxEdgeLength, int numberOfVertices)
   {
      if (numberOfVertices == 0)
         return Collections.emptyList();
      if (numberOfVertices == 1)
         return Collections.singletonList(generateRandomPoint2D(random, centerMinMax));
      if (numberOfVertices == 2)
      {
         Vector2D halfEdgeLentgh = generateRandomVector2DWithFixedLength(random, 0.5 * maxEdgeLength * random.nextDouble());
         Point2D center = generateRandomPoint2D(random, centerMinMax);
         Point2D a = new Point2D();
         Point2D b = new Point2D();
         a.add(center, halfEdgeLentgh);
         b.sub(center, halfEdgeLentgh);
         List<Point2D> points = new ArrayList<>();
         points.add(a);
         points.add(b);
         return points;
      }

      // Generating random angles from vertex to vertex
      double[] dTheta = new double[numberOfVertices];
      double sum = 0.0;

      for (int i = 0; i < numberOfVertices; i++)
      {
         dTheta[i] = generateRandomDouble(random, 0.001, 1.0);
         sum += dTheta[i];
      }
      // Adding the angle for the last segment
      sum += random.nextDouble();

      // Re-scaling the all the angles such that sum is equal to 2*pi
      double scale = 2.0 * Math.PI / sum;

      for (int i = 0; i < numberOfVertices; i++)
         dTheta[i] *= scale;

      // Generating the clockwise ordered vertices distributed on a circle centered at (0, 0).
      List<Point2D> clockwiseVertices = new ArrayList<>();
      double theta = 0.0;
      // Add a random yaw angle on all the vertices
      double yaw = generateRandomDouble(random, Math.PI);
      clockwiseVertices.add(new Point2D(Math.cos(yaw), Math.sin(yaw)));

      for (int i = 1; i < numberOfVertices; i++)
      {
         theta -= dTheta[i];
         double x = Math.cos(theta + yaw);
         double y = Math.sin(theta + yaw);
         clockwiseVertices.add(new Point2D(x, y));
      }

      // Re-scaling the vertices such that the max edge length is contained in [0, maxEdgeLength]
      double currentMaxEdgeLength = 0.0;
      for (int i = 0; i < numberOfVertices; i++)
      {
         Point2D vertex = clockwiseVertices.get(i);
         Point2D nextVertex = clockwiseVertices.get((i + 1) % numberOfVertices);
         currentMaxEdgeLength = Math.max(currentMaxEdgeLength, vertex.distance(nextVertex));
      }

      // Limiting the min value from the random to prevent obtaining a polygon that is way too small
      scale = generateRandomDouble(random, 0.1, 1.0) * maxEdgeLength / currentMaxEdgeLength;
      for (int i = 0; i < numberOfVertices; i++)
         clockwiseVertices.get(i).scale(scale);

      // By definition in this library, a convex polygon's first vertex is located has the min x coordinate.
      // If more than one vertex is located at min X, then it is the vertex with the max Y that is the first.
      int indexOfFirstVertex = 0;
      Point2D firstVertex = clockwiseVertices.get(0);

      for (int i = 0; i < numberOfVertices; i++)
      {
         Point2D currentVertex = clockwiseVertices.get(i);
         if (firstVertex.getX() > currentVertex.getX())
         {
            firstVertex = currentVertex;
            indexOfFirstVertex = i;
         }
         else if (firstVertex.getX() == currentVertex.getX() && firstVertex.getY() < currentVertex.getY())
         {
            firstVertex = currentVertex;
            indexOfFirstVertex = i;
         }
      }

      // Make a new list with the vertices properly ordered and shifted to be around a random center
      Point2D center = generateRandomPoint2D(random, centerMinMax);
      List<Point2D> convexPolygon2D = new ArrayList<>();

      for (int i = 0; i < numberOfVertices; i++)
      {
         int indexInOtherList = (i + indexOfFirstVertex) % numberOfVertices;
         Point2D vertex = clockwiseVertices.get(indexInOtherList);
         vertex.add(center);
         convexPolygon2D.add(vertex);
      }

      return convexPolygon2D;
   }
}
