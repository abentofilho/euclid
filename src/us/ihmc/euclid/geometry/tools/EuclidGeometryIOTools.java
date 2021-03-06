package us.ihmc.euclid.geometry.tools;

import static us.ihmc.euclid.tools.EuclidCoreIOTools.*;

import us.ihmc.euclid.geometry.BoundingBox2D;
import us.ihmc.euclid.geometry.BoundingBox3D;
import us.ihmc.euclid.geometry.Line3D;
import us.ihmc.euclid.geometry.LineSegment3D;
import us.ihmc.euclid.tuple2D.interfaces.Point2DReadOnly;
import us.ihmc.euclid.tuple3D.interfaces.Point3DReadOnly;
import us.ihmc.euclid.tuple3D.interfaces.Vector3DReadOnly;

public class EuclidGeometryIOTools
{
   /** Default format used to print decimal numbers. */
   private static final String DEFAULT_FORMAT = getStringFormat(6, 3);

   /**
    * Gets a representative {@code String} of {@code line3D} as follows:
    *
    * <pre>
    * Line 3D: point = ( 0.174,  0.732, -0.222 ), direction = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param line3D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getLine3DString(Line3D line3D)
   {
      return getLine3DString(DEFAULT_FORMAT, line3D);
   }

   /**
    * Gets a representative {@code String} of {@code line3D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Line 3D: point = ( 0.174,  0.732, -0.222 ), direction = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param line3D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getLine3DString(String format, Line3D line3D)
   {
      if (line3D == null)
         return "null";
      else
         return getLine3DString(format, line3D.getPoint(), line3D.getDirection());
   }

   /**
    * Gets a representative {@code String} of {@code line3D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Line 3D: point = ( 0.174,  0.732, -0.222 ), direction = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param pointOnLine a point located on the line to get the {@code String} of. Not modified.
    * @param lineDirection the direction of the line to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getLine3DString(String format, Point3DReadOnly pointOnLine, Vector3DReadOnly lineDirection)
   {
      return "Line 3D: point = " + getTuple3DString(format, pointOnLine) + ", direction = " + getTuple3DString(format, lineDirection);
   }

   /**
    * Gets a representative {@code String} of {@code lineSegment3D} as follows:
    *
    * <pre>
    * Line segment 3D: 1st endpoint = ( 0.174,  0.732, -0.222 ), 2nd endpoint = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param lineSegment3D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getLineSegment3DString(LineSegment3D lineSegment3D)
   {
      return getLineSegment3DString(DEFAULT_FORMAT, lineSegment3D);
   }

   /**
    * Gets a representative {@code String} of {@code lineSegment3D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Line segment 3D: 1st endpoint = ( 0.174,  0.732, -0.222 ), 2nd endpoint = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param lineSegment3D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getLineSegment3DString(String format, LineSegment3D lineSegment3D)
   {
      if (lineSegment3D == null)
         return "null";
      else
         return getLineSegment3DString(format, lineSegment3D.getFirstEndpoint(), lineSegment3D.getSecondEndpoint());
   }

   /**
    * Gets a representative {@code String} of {@code lineSegment3D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Line segment 3D: 1st endpoint = ( 0.174,  0.732, -0.222 ), 2nd endpoint = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param lineSegmentStart the first endpoint of the line segment to get the {@code String} of. Not modified.
    * @param lineSegmentEnd the second endpoint of the line segment to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getLineSegment3DString(String format, Point3DReadOnly lineSegmentStart, Point3DReadOnly lineSegmentEnd)
   {
      return "Line segment 3D: 1st endpoint = " + getTuple3DString(format, lineSegmentStart) + ", 2nd endpoint = " + getTuple3DString(format, lineSegmentEnd);
   }

   /**
    * Gets a representative {@code String} of {@code boundingBox2D} as follows:
    *
    * <pre>
    * Bounding Box 2D: min = ( 0.174,  0.732 ), max = (-0.558, -0.380 )
    * </pre>
    * </p>
    *
    * @param boundingBox2D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getBoundingBox2DString(BoundingBox2D boundingBox2D)
   {
      return getBoundingBox2DString(DEFAULT_FORMAT, boundingBox2D);
   }

   /**
    * Gets a representative {@code String} of {@code boundingBox2D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Bounding Box 2D: min = ( 0.174,  0.732 ), max = (-0.558, -0.380 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param boundingBox2D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getBoundingBox2DString(String format, BoundingBox2D boundingBox2D)
   {
      return getBoundingBox2DString(format, boundingBox2D.getMinPoint(), boundingBox2D.getMaxPoint());
   }

   /**
    * Gets a representative {@code String} of {@code boundingBox2D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Bounding Box 2D: min = ( 0.174,  0.732 ), max = (-0.558, -0.380 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param boundingBoxMin the minimum coordinate of the bounding box to get the {@code String} of. Not modified.
    * @param boundingBoxMax the maximum coordinate of the bounding box to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getBoundingBox2DString(String format, Point2DReadOnly boundingBoxMin, Point2DReadOnly boundingBoxMax)
   {
      return "Bounding Box 2D: min = " + getTuple2DString(format, boundingBoxMin) + ", max = " + getTuple2DString(format, boundingBoxMax);
   }

   /**
    * Gets a representative {@code String} of {@code boundingBox3D} as follows:
    *
    * <pre>
    * Bounding Box 3D: min = ( 0.174,  0.732, -0.222 ), max = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param boundingBox3D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getBoundingBox3DString(BoundingBox3D boundingBox3D)
   {
      return getBoundingBox3DString(DEFAULT_FORMAT, boundingBox3D);
   }

   /**
    * Gets a representative {@code String} of {@code boundingBox3D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Bounding Box 3D: min = ( 0.174,  0.732, -0.222 ), max = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param boundingBox3D the object to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getBoundingBox3DString(String format, BoundingBox3D boundingBox3D)
   {
      return getBoundingBox3DString(format, boundingBox3D.getMinPoint(), boundingBox3D.getMaxPoint());
   }

   /**
    * Gets a representative {@code String} of {@code boundingBox3D} given a specific format to use.
    * <p>
    * Using the default format {@link #DEFAULT_FORMAT}, this provides a {@code String} as follows:
    *
    * <pre>
    * Bounding Box 3D: min = ( 0.174,  0.732, -0.222 ), max = (-0.558, -0.380,  0.130 )
    * </pre>
    * </p>
    *
    * @param format the format to use for each number.
    * @param boundingBoxMin the minimum coordinate of the bounding box to get the {@code String} of. Not modified.
    * @param boundingBoxMax the maximum coordinate of the bounding box to get the {@code String} of. Not modified.
    * @return the representative {@code String}.
    */
   public static String getBoundingBox3DString(String format, Point3DReadOnly boundingBoxMin, Point3DReadOnly boundingBoxMax)
   {
      return "Bounding Box 3D: min = " + getTuple3DString(format, boundingBoxMin) + ", max = " + getTuple3DString(format, boundingBoxMax);
   }

}
