package us.ihmc.euclid.geometry;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import us.ihmc.euclid.geometry.tools.EuclidGeometryTools;
import us.ihmc.euclid.tools.EuclidCoreRandomTools;
import us.ihmc.euclid.tools.EuclidCoreTestTools;
import us.ihmc.euclid.tuple2D.Point2D;
import us.ihmc.euclid.tuple2D.Vector2D;

public class LineSegment2DTest
{
   private static Random ran = new Random(100L);
   private static LineSegment2D testSegment1;
   private static Point2D segment1Point1;
   private static Point2D segment1Point2;

   private static LineSegment2D testSegment2;
   private static Point2D segment2Point1;
   private static Point2D segment2Point2;

   @Before
   public void setUp() throws Exception
   {
      double x1;
      double y1;
      double x2;
      double y2;

      do
      {
         x1 = ran.nextDouble() * 500 - 250;
         y1 = ran.nextDouble() * 500 - 250;
         x2 = ran.nextDouble() * 500 - 250;
         y2 = ran.nextDouble() * 500 - 250;

      }
      while ((x1 == x2) || (y1 == y2));

      segment1Point1 = new Point2D(x1, y1);
      segment1Point2 = new Point2D(x2, y2);
      testSegment1 = new LineSegment2D(segment1Point1, segment1Point2);

      do
      {
         x1 = ran.nextDouble() * 500 - 250;
         y1 = ran.nextDouble() * 500 - 250;
         x2 = ran.nextDouble() * 500 - 250;
         y2 = ran.nextDouble() * 500 - 250;
      }
      while ((x1 == x2) || (y1 == y2));

      segment2Point1 = new Point2D(x1, y1);
      segment2Point2 = new Point2D(x2, y2);
      testSegment2 = new LineSegment2D(segment2Point1, segment2Point2);
   }

   @After
   public void tearDown() throws Exception
   {
      testSegment1 = null;
      testSegment2 = null;
   }

   @Test
   public void testDistancePoint2dLineSegment2d()
   {
      LineSegment2D line1 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      Point2D point1 = new Point2D(-10.0, 10.0);
      Point2D point2 = new Point2D(0.0, 10.0);
      Point2D point3 = new Point2D(0.0, -10.0);
      Point2D point4 = new Point2D(-10.0, 0.0);
      Point2D point5 = new Point2D(10.0, 0.0);
      Point2D point6 = new Point2D(10.5, 0.0);
      Point2D point7 = new Point2D(0.0, 1.2);
      Point2D point8 = new Point2D(10.1, 0.0);
      Point2D point9 = new Point2D(0.0, 0.0);
      double delta = 0.00001;
      assertEquals(10.0, line1.distance(point1), delta);
      assertEquals(10.0, line1.distance(point2), delta);
      assertEquals(10.0, line1.distance(point3), delta);
      assertEquals(0.0, line1.distance(point4), delta);
      assertEquals(0.0, line1.distance(point5), delta);
      assertEquals(0.5, line1.distance(point6), delta);
      assertEquals(1.2, line1.distance(point7), delta);
      assertEquals(0.1, line1.distance(point8), delta);
      assertEquals(0.0, line1.distance(point9), delta);
   }

   @Test
   public void testLineSegment2dDoubleDoubleDoubleDouble()
   {
      // WORKING CASES
      for (int i = 0; i < 100; i++)
      {
         double x1 = ran.nextDouble() * 500 - 250;
         double y1 = ran.nextDouble() * 500 - 250;
         double x2 = ran.nextDouble() * 500 - 250;
         double y2 = ran.nextDouble() * 500 - 250;

         if ((x1 != x2) || (y1 != y2))
         {
            LineSegment2D test = new LineSegment2D(x1, y1, x2, y2);
            assertEquals(test.getFirstEndpointCopy().getX(), x1, 0.001);
            assertEquals(test.getFirstEndpointCopy().getY(), y1, 0.001);
            assertEquals(test.getSecondEndpointCopy().getX(), x2, 0.001);
            assertEquals(test.getSecondEndpointCopy().getY(), y2, 0.001);
         }
      }
   }

   @Test
   public void testLineSegment2dPoint2dArray()
   {
      // WORKING CASES
      for (int i = 0; i < 100; i++)
      {
         double x1 = ran.nextDouble() * 500 - 250;
         double y1 = ran.nextDouble() * 500 - 250;
         double x2 = ran.nextDouble() * 500 - 250;
         double y2 = ran.nextDouble() * 500 - 250;

         if ((x1 != x2) || (y1 != y2))
         {
            Point2D[] points = new Point2D[2];
            points[0] = new Point2D(x1, y1);
            points[1] = new Point2D(x2, y2);
            LineSegment2D test = new LineSegment2D(points);
            assertEquals(test.getFirstEndpointCopy(), points[0]);
            assertEquals(test.getSecondEndpointCopy(), points[1]);
         }
      }
   }

   @Test
   public void testLineSegment2dPoint2dPoint2d()
   {
      // WORKING CASES
      for (int i = 0; i < 100; i++)
      {
         double x1 = ran.nextDouble() * 500 - 250;
         double y1 = ran.nextDouble() * 500 - 250;
         double x2 = ran.nextDouble() * 500 - 250;
         double y2 = ran.nextDouble() * 500 - 250;

         if ((x1 != x2) || (y1 != y2))
         {
            Point2D[] points = new Point2D[2];
            points[0] = new Point2D(x1, y1);
            points[1] = new Point2D(x2, y2);
            LineSegment2D test = new LineSegment2D(points[0], points[1]);
            assertEquals(test.getFirstEndpointCopy(), points[0]);
            assertEquals(test.getSecondEndpointCopy(), points[1]);
         }
      }
   }

   @Test
   public void testLineSegment2dLineSegment2d()
   {
      // WORKING CASES
      for (int i = 0; i < 100; i++)
      {
         double x1 = ran.nextDouble() * 500 - 250;
         double y1 = ran.nextDouble() * 500 - 250;
         double x2 = ran.nextDouble() * 500 - 250;
         double y2 = ran.nextDouble() * 500 - 250;

         if ((x1 != x2) || (y1 != y2))
         {
            Point2D[] points = new Point2D[2];
            points[0] = new Point2D(x1, y1);
            points[1] = new Point2D(x2, y2);
            LineSegment2D test = new LineSegment2D(points[0], points[1]);
            LineSegment2D test2 = new LineSegment2D(test);
            assertEquals(test.getFirstEndpointCopy(), test2.getFirstEndpointCopy());
            assertEquals(test.getSecondEndpointCopy(), test2.getSecondEndpointCopy());
         }
      }

   }

   @Test
   public void testGetEndpointsCopy()
   {
      Point2D[] pointsCopy = testSegment1.getEndpointsCopy();
      assertEquals(pointsCopy[0], testSegment1.getFirstEndpointCopy());
      assertEquals(pointsCopy[1], testSegment1.getSecondEndpointCopy());
      assertEquals(pointsCopy[0], segment1Point1);
      assertEquals(pointsCopy[1], segment1Point2);

      // make sure that chaning the copy does not change the origional
      pointsCopy[0].set(pointsCopy[0].getX() - 10.0, pointsCopy[0].getY() - 10.0);
      pointsCopy[1].set(pointsCopy[1].getX() - 10.0, pointsCopy[1].getY() - 10.0);

      assertFalse(pointsCopy[0].equals(testSegment1.getFirstEndpointCopy()));
      assertFalse(pointsCopy[1].equals(testSegment1.getSecondEndpointCopy()));
      assertFalse(pointsCopy[0].equals(segment1Point1));
      assertFalse(pointsCopy[1].equals(segment1Point2));

   }

   @Test
   public void testGetFirstEndPointCopy()
   {
      Point2D pointCopy = testSegment1.getFirstEndpointCopy();
      assertEquals(pointCopy, segment1Point1);

      // make sure that chaning the copy does not change the origional
      pointCopy.set(pointCopy.getX() - 10.0, pointCopy.getY() - 10.0);

      assertFalse(pointCopy.equals(segment1Point1));

   }

   @Test
   public void testGetSecondEndPointCopy()
   {
      Point2D pointCopy = testSegment1.getSecondEndpointCopy();
      assertEquals(pointCopy, segment1Point2);

      // make sure that chaning the copy does not change the origional
      pointCopy.set(pointCopy.getX() - 10.0, pointCopy.getY() - 10.0);

      assertFalse(pointCopy.equals(segment1Point2));

   }

   @Test
   public void testSetPoint2dPoint2d()
   {
      Point2D[] pointsCopy = testSegment1.getEndpointsCopy();

      pointsCopy[0].set(pointsCopy[0].getX() - 10.0, pointsCopy[0].getY() - 10.0);
      pointsCopy[1].set(pointsCopy[1].getX() - 10.0, pointsCopy[1].getY() - 10.0);

      testSegment1.set(pointsCopy[0], pointsCopy[1]);

      assertEquals(pointsCopy[0], testSegment1.getFirstEndpointCopy());
      assertEquals(pointsCopy[1], testSegment1.getSecondEndpointCopy());
   }

   @Test
   public void testSetDoubleDoubleDoubleDouble()
   {
      Point2D[] pointsCopy = testSegment1.getEndpointsCopy();

      pointsCopy[0].set(pointsCopy[0].getX() - 10.0, pointsCopy[0].getY() - 10.0);
      pointsCopy[1].set(pointsCopy[1].getX() - 10.0, pointsCopy[1].getY() - 10.0);

      testSegment1.set(pointsCopy[0].getX(), pointsCopy[0].getY(), pointsCopy[1].getX(), pointsCopy[1].getY());

      assertEquals(pointsCopy[0], testSegment1.getFirstEndpointCopy());
      assertEquals(pointsCopy[1], testSegment1.getSecondEndpointCopy());
   }

   @Test
   public void testSetPoint2dArray()
   {
      Point2D[] pointsCopy = testSegment1.getEndpointsCopy();

      pointsCopy[0].set(pointsCopy[0].getX() - 10.0, pointsCopy[0].getY() - 10.0);
      pointsCopy[1].set(pointsCopy[1].getX() - 10.0, pointsCopy[1].getY() - 10.0);

      testSegment1.set(pointsCopy);

      assertEquals(pointsCopy[0], testSegment1.getFirstEndpointCopy());
      assertEquals(pointsCopy[1], testSegment1.getSecondEndpointCopy());
   }

   @Test
   public void testSetLineSegment2d()
   {
      testSegment1.set(testSegment2);

      assertEquals(testSegment2.getFirstEndpointCopy(), testSegment1.getFirstEndpointCopy());
      assertEquals(testSegment2.getSecondEndpointCopy(), testSegment1.getSecondEndpointCopy());
   }

   @Test
   public void testFlipDirection()
   {
      testSegment1.flipDirection();
      assertEquals(segment1Point2, testSegment1.getFirstEndpointCopy());
      assertEquals(segment1Point1, testSegment1.getSecondEndpointCopy());

   }

   @Test
   public void testMidpoint()
   {
      Point2D midPoint = testSegment1.midpoint();
      assertEquals(midPoint.distance(testSegment1.getFirstEndpointCopy()), midPoint.distance(testSegment1.getSecondEndpointCopy()), 0.001);
   }

   @Test
   public void testLength()
   {
      assertEquals(segment1Point1.distance(segment1Point2), testSegment1.length(), 0.001);
      testSegment1.flipDirection();
      assertEquals(segment1Point1.distance(segment1Point2), testSegment1.length(), 0.001);

   }

   @Test
   public void testPercentageAlongLineSegment()
   {
      LineSegment2D line1 = new LineSegment2D(-10, 0, 10, 0);
      assertEquals(0.5, line1.percentageAlongLineSegment(new Point2D(0.0, 0.0)), 0.001);
      assertEquals(0.0, line1.percentageAlongLineSegment(new Point2D(-10.0, 0.0)), 0.001);
      assertEquals(1.0, line1.percentageAlongLineSegment(new Point2D(10.0, 0.0)), 0.001);
      assertEquals(0.5, line1.percentageAlongLineSegment(new Point2D(0.0, 5.0)), 0.001);

      Random random = new Random(23424L);

      // Test on line segment
      for (int i = 0; i < 1000; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);

         Point2D pointOnLineSegment = new Point2D();

         // Test between end points
         double expectedPercentage = EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 1.0);
         pointOnLineSegment.interpolate(lineSegmentStart, lineSegmentEnd, expectedPercentage);
         double actualPercentage = lineSegment.percentageAlongLineSegment(pointOnLineSegment);
         assertEquals(expectedPercentage, actualPercentage, EuclidGeometryTools.ONE_TRILLIONTH);

         // Test before end points
         expectedPercentage = EuclidCoreRandomTools.generateRandomDouble(random, -10.0, 0.0);
         pointOnLineSegment.interpolate(lineSegmentStart, lineSegmentEnd, expectedPercentage);
         actualPercentage = lineSegment.percentageAlongLineSegment(pointOnLineSegment);
         assertEquals(expectedPercentage, actualPercentage, EuclidGeometryTools.ONE_TRILLIONTH);

         // Test after end points
         expectedPercentage = EuclidCoreRandomTools.generateRandomDouble(random, 1.0, 10.0);
         pointOnLineSegment.interpolate(lineSegmentStart, lineSegmentEnd, expectedPercentage);
         actualPercentage = lineSegment.percentageAlongLineSegment(pointOnLineSegment);
         assertEquals(expectedPercentage, actualPercentage, EuclidGeometryTools.ONE_TRILLIONTH);
      }

      // Test off line segment
      for (int i = 0; i < 1000; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);

         Point2D pointOffLineSegment = new Point2D();
         Vector2D lineSegmentDirection = new Vector2D();
         lineSegmentDirection.sub(lineSegmentEnd, lineSegmentStart);
         Vector2D orthogonal = EuclidGeometryTools.perpendicularVector2D(lineSegmentDirection);
         orthogonal.normalize();

         // Test between end points
         double expectedPercentage = EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 1.0);
         pointOffLineSegment.interpolate(lineSegmentStart, lineSegmentEnd, expectedPercentage);
         pointOffLineSegment.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 10.0), orthogonal, pointOffLineSegment);
         double actualPercentage = lineSegment.percentageAlongLineSegment(pointOffLineSegment);
         assertEquals(expectedPercentage, actualPercentage, EuclidGeometryTools.ONE_TRILLIONTH);

         // Test before end points
         expectedPercentage = EuclidCoreRandomTools.generateRandomDouble(random, -10.0, 0.0);
         pointOffLineSegment.interpolate(lineSegmentStart, lineSegmentEnd, expectedPercentage);
         pointOffLineSegment.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 10.0), orthogonal, pointOffLineSegment);
         actualPercentage = lineSegment.percentageAlongLineSegment(pointOffLineSegment);
         assertEquals(expectedPercentage, actualPercentage, EuclidGeometryTools.ONE_TRILLIONTH);

         // Test after end points
         expectedPercentage = EuclidCoreRandomTools.generateRandomDouble(random, 1.0, 10.0);
         pointOffLineSegment.interpolate(lineSegmentStart, lineSegmentEnd, expectedPercentage);
         pointOffLineSegment.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 10.0), orthogonal, pointOffLineSegment);
         actualPercentage = lineSegment.percentageAlongLineSegment(pointOffLineSegment);
         assertEquals(expectedPercentage, actualPercentage, EuclidGeometryTools.ONE_TRILLIONTH);
      }
   }

   @Test
   public void testIntersectionWithLineSegment2d1()
   {
      LineSegment2D line1 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      LineSegment2D line2 = new LineSegment2D(-10.0, 10.0, 10.0, 0.0);
      LineSegment2D line3 = new LineSegment2D(0.0, 10.0, 0.0, -10.0);
      LineSegment2D line4 = new LineSegment2D(0.0, -10.0, 0.0, 10.0);
      LineSegment2D line5 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      LineSegment2D line6 = new LineSegment2D(10.0, 0.0, -10.0, 0.0);
      LineSegment2D line7 = new LineSegment2D(10.0, 0.0, 20.0, 0.0);
      LineSegment2D line8 = new LineSegment2D(10.0, 0.0, -20.0, 0.0);
      LineSegment2D line9 = new LineSegment2D(10.1, 0.0, 20.0, 0.0);

      assertEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line1));
      assertEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line5));
      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line6));
      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line2));
      assertEquals(new Point2D(0.0, 0.0), line1.intersectionWith(line3));
      assertEquals(new Point2D(0.0, 0.0), line1.intersectionWith(line4));

      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line7));
      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line8));
      assertEquals(null, line1.intersectionWith(line9));
   }

   @Test
   public void testIntersectionWithLineSegment2d2()
   {
      Random random = new Random(3242L);

      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart1 = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd1 = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);

         Point2D expectedIntersection = new Point2D();
         expectedIntersection.interpolate(lineSegmentStart1, lineSegmentEnd1, EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 1.0));

         Vector2D lineDirection2 = EuclidCoreRandomTools.generateRandomVector2DWithFixedLength(random, 1.0);

         Point2D lineSegmentStart2 = new Point2D();
         Point2D lineSegmentEnd2 = new Point2D();

         // Expecting intersection
         lineSegmentStart2.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection2, expectedIntersection);
         lineSegmentEnd2.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, -10.0, 0.0), lineDirection2, expectedIntersection);
         assertAllCombinationsOfIntersectionWith(expectedIntersection, lineSegmentStart1, lineSegmentEnd1, lineSegmentStart2, lineSegmentEnd2);

         // Not expecting intersection
         lineSegmentStart2.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection2, expectedIntersection);
         lineSegmentEnd2.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection2, expectedIntersection);
         assertOnlyExistenceOfIntersectionAllCombinations(false, lineSegmentStart1, lineSegmentEnd1, lineSegmentStart2, lineSegmentEnd2);
      }

      // Test intersection at one of the end points
      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart1 = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd1 = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);

         Point2D expectedIntersection = new Point2D(lineSegmentStart1);

         Vector2D lineDirection2 = EuclidCoreRandomTools.generateRandomVector2DWithFixedLength(random, 1.0);

         Point2D lineSegmentStart2 = new Point2D();
         Point2D lineSegmentEnd2 = new Point2D();

         // Not expecting intersection
         lineSegmentStart2.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection2, expectedIntersection);
         lineSegmentEnd2.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, -10.0, 0.0), lineDirection2, expectedIntersection);
         assertAllCombinationsOfIntersectionWith(expectedIntersection, lineSegmentStart1, lineSegmentEnd1, lineSegmentStart2, lineSegmentEnd2);
      }

      // Test with parallel/collinear line segments
      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart1 = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd1 = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);

         Point2D lineSegmentStart2 = new Point2D();
         Point2D lineSegmentEnd2 = new Point2D();

         double alpha1 = EuclidCoreRandomTools.generateRandomDouble(random, 2.0);
         double alpha2 = EuclidCoreRandomTools.generateRandomDouble(random, 2.0);

         // Make the second line segment collinear to the first one
         lineSegmentStart2.interpolate(lineSegmentStart1, lineSegmentEnd1, alpha1);
         lineSegmentEnd2.interpolate(lineSegmentStart1, lineSegmentEnd1, alpha2);

         if ((0.0 < alpha1 && alpha1 < 1.0) || (0.0 < alpha2 && alpha2 < 1.0) || alpha1 * alpha2 < 0.0)
         {
            assertOnlyExistenceOfIntersectionAllCombinations(true, lineSegmentStart1, lineSegmentEnd1, lineSegmentStart2, lineSegmentEnd2);
         }
         else
         {
            assertOnlyExistenceOfIntersectionAllCombinations(false, lineSegmentStart1, lineSegmentEnd1, lineSegmentStart2, lineSegmentEnd2);
         }

         // Shift the second line segment such that it becomes only parallel to the first.
         Vector2D orthogonal = new Vector2D();
         orthogonal.sub(lineSegmentEnd1, lineSegmentStart1);
         orthogonal.set(-orthogonal.getY(), orthogonal.getX());
         orthogonal.normalize();

         double distance = EuclidCoreRandomTools.generateRandomDouble(random, 1.0e-10, 10.0);
         lineSegmentStart2.scaleAdd(distance, orthogonal, lineSegmentStart2);
         lineSegmentEnd2.scaleAdd(distance, orthogonal, lineSegmentEnd2);
         assertOnlyExistenceOfIntersectionAllCombinations(false, lineSegmentStart1, lineSegmentEnd1, lineSegmentStart2, lineSegmentEnd2);
      }
   }

   private void assertOnlyExistenceOfIntersectionAllCombinations(boolean intersectionExist, Point2D lineSegmentStart1, Point2D lineSegmentEnd1,
                                                                 Point2D lineSegmentStart2, Point2D lineSegmentEnd2)
   {
      LineSegment2D lineSegment1 = new LineSegment2D(lineSegmentStart1, lineSegmentEnd1);
      LineSegment2D reverseLineSegment1 = new LineSegment2D(lineSegmentEnd1, lineSegmentStart1);
      LineSegment2D lineSegment2 = new LineSegment2D(lineSegmentStart2, lineSegmentEnd2);
      LineSegment2D reverseLineSegment2 = new LineSegment2D(lineSegmentEnd2, lineSegmentStart2);

      if (intersectionExist)
      {
         assertNotNull(lineSegment1.intersectionWith(lineSegment2));
         assertNotNull(lineSegment1.intersectionWith(reverseLineSegment2));
         assertNotNull(reverseLineSegment1.intersectionWith(lineSegment2));
         assertNotNull(reverseLineSegment1.intersectionWith(reverseLineSegment2));

         assertNotNull(lineSegment2.intersectionWith(lineSegment1));
         assertNotNull(lineSegment2.intersectionWith(reverseLineSegment1));
         assertNotNull(reverseLineSegment2.intersectionWith(lineSegment1));
         assertNotNull(reverseLineSegment2.intersectionWith(reverseLineSegment1));
      }
      else
      {
         assertNull(lineSegment1.intersectionWith(lineSegment2));
         assertNull(lineSegment1.intersectionWith(reverseLineSegment2));
         assertNull(reverseLineSegment1.intersectionWith(lineSegment2));
         assertNull(reverseLineSegment1.intersectionWith(reverseLineSegment2));

         assertNull(lineSegment2.intersectionWith(lineSegment1));
         assertNull(lineSegment2.intersectionWith(reverseLineSegment1));
         assertNull(reverseLineSegment2.intersectionWith(lineSegment1));
         assertNull(reverseLineSegment2.intersectionWith(reverseLineSegment1));
      }
   }

   private void assertAllCombinationsOfIntersectionWith(Point2D expectedIntersection, Point2D lineSegmentStart1, Point2D lineSegmentEnd1,
                                                        Point2D lineSegmentStart2, Point2D lineSegmentEnd2)
   {
      double epsilon = EuclidGeometryTools.ONE_TRILLIONTH;

      LineSegment2D lineSegment1 = new LineSegment2D(lineSegmentStart1, lineSegmentEnd1);
      LineSegment2D reverseLineSegment1 = new LineSegment2D(lineSegmentEnd1, lineSegmentStart1);
      LineSegment2D lineSegment2 = new LineSegment2D(lineSegmentStart2, lineSegmentEnd2);
      LineSegment2D reverseLineSegment2 = new LineSegment2D(lineSegmentEnd2, lineSegmentStart2);

      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, lineSegment1.intersectionWith(lineSegment2), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, lineSegment1.intersectionWith(reverseLineSegment2), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, reverseLineSegment1.intersectionWith(lineSegment2), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, reverseLineSegment1.intersectionWith(reverseLineSegment2), epsilon);

      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, lineSegment2.intersectionWith(lineSegment1), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, lineSegment2.intersectionWith(reverseLineSegment1), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, reverseLineSegment2.intersectionWith(lineSegment1), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, reverseLineSegment2.intersectionWith(reverseLineSegment1), epsilon);
   }

   @Test
   public void testIntersectionWithLine2d2()
   {
      double epsilon = EuclidGeometryTools.ONE_TRILLIONTH;
      Random random = new Random(23423L);

      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);
         LineSegment2D reverseLineSegment = new LineSegment2D(lineSegmentEnd, lineSegmentStart);

         Point2D expectedIntersection = new Point2D();
         expectedIntersection.interpolate(lineSegmentStart, lineSegmentEnd, EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 1.0));

         Point2D pointOnLine = new Point2D(expectedIntersection);
         Vector2D lineDirection = EuclidCoreRandomTools.generateRandomVector2DWithFixedLength(random, 1.0);

         // Expecting intersection
         Point2D actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);

         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);

         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, expectedIntersection);
         actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);

         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);
      }

      // Make the intersection happen outside the line segment
      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);
         LineSegment2D reverseLineSegment = new LineSegment2D(lineSegmentEnd, lineSegmentStart);

         Point2D pointOnLine = new Point2D();
         Vector2D lineDirection = EuclidCoreRandomTools.generateRandomVector2DWithFixedLength(random, 1.0);

         Point2D lineLineIntersection = new Point2D();
         lineLineIntersection.interpolate(lineSegmentStart, lineSegmentEnd, EuclidCoreRandomTools.generateRandomDouble(random, 1.0, 2.0));
         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, lineLineIntersection);
         Point2D actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         assertNull(actualIntersection);

         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         assertNull(actualIntersection);

         lineLineIntersection.interpolate(lineSegmentStart, lineSegmentEnd, EuclidCoreRandomTools.generateRandomDouble(random, -1.0, 0.0));
         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, lineLineIntersection);
         actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         assertNull(actualIntersection);

         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         assertNull(actualIntersection);
      }

      // Make the intersection happen on each end point of the line segment
      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);
         LineSegment2D reverseLineSegment = new LineSegment2D(lineSegmentEnd, lineSegmentStart);

         Point2D pointOnLine = new Point2D();
         Vector2D lineDirection = EuclidCoreRandomTools.generateRandomVector2DWithFixedLength(random, 1.0);

         Point2D expectedIntersection = new Point2D();
         expectedIntersection.set(lineSegmentStart);
         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, expectedIntersection);
         Point2D actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);

         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);

         expectedIntersection.set(lineSegmentEnd);
         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, expectedIntersection);
         actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);

         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(expectedIntersection, actualIntersection, epsilon);
      }

      // Make the line segment and the line parallel not collinear.
      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);

         Point2D pointOnLine = new Point2D(lineSegmentStart);
         Vector2D lineDirection = new Vector2D();
         lineDirection.sub(lineSegmentEnd, lineSegmentStart);
         lineDirection.normalize();
         if (random.nextBoolean())
            lineDirection.negate();

         Vector2D orthogonal = new Vector2D(-lineDirection.getY(), lineDirection.getY());

         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), orthogonal, pointOnLine);
         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, pointOnLine);
         Point2D actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         assertNull(actualIntersection);
      }

      // Make the line segment and the line collinear.
      for (int i = 0; i < 100; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);
         LineSegment2D reverseLineSegment = new LineSegment2D(lineSegmentEnd, lineSegmentStart);

         Point2D pointOnLine = new Point2D(lineSegmentStart);
         Vector2D lineDirection = new Vector2D();
         lineDirection.sub(lineSegmentEnd, lineSegmentStart);
         lineDirection.normalize();
         if (random.nextBoolean())
            lineDirection.negate();

         pointOnLine.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 10.0), lineDirection, pointOnLine);
         Point2D actualIntersection = lineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(lineSegmentStart, actualIntersection, epsilon);
         actualIntersection = reverseLineSegment.intersectionWith(new Line2D(pointOnLine, lineDirection));
         EuclidCoreTestTools.assertTuple2DEquals(lineSegmentEnd, actualIntersection, epsilon);
      }
   }

   @Test
   public void testDistancePoint2d()
   {
      LineSegment2D line1 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      Point2D point1 = new Point2D(-10.0, 10.0);
      Point2D point2 = new Point2D(0.0, 10.0);
      Point2D point3 = new Point2D(0.0, -10.0);
      Point2D point4 = new Point2D(-10.0, 0.0);
      Point2D point5 = new Point2D(10.0, 0.0);
      Point2D point6 = new Point2D(10.5, 0.0);
      Point2D point7 = new Point2D(0.0, 1.2);
      Point2D point8 = new Point2D(10.1, 0.0);
      Point2D point9 = new Point2D(0.0, 0.0);
      double delta = 0.00001;
      assertEquals(10.0, line1.distance(point1), delta);
      assertEquals(10.0, line1.distance(point2), delta);
      assertEquals(10.0, line1.distance(point3), delta);
      assertEquals(0.0, line1.distance(point4), delta);
      assertEquals(0.0, line1.distance(point5), delta);
      assertEquals(0.5, line1.distance(point6), delta);
      assertEquals(1.2, line1.distance(point7), delta);
      assertEquals(0.1, line1.distance(point8), delta);
      assertEquals(0.0, line1.distance(point9), delta);
   }

   @Test
   public void testShiftToLeftAndRightCopy()
   {
      double distanceToShift = 0.2;
      double epsilon = 1e-7;

      // Pointing straight up:
      LineSegment2D lineSegment = new LineSegment2D(0.0, 0.0, 0.0, 1.0);
      LineSegment2D shiftedLineSegment = lineSegment.shiftToRightCopy(distanceToShift);

      Point2D firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      Point2D secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(distanceToShift, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(0.0, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(distanceToShift, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getY(), epsilon);

      shiftedLineSegment = lineSegment.shiftToLeftCopy(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(-distanceToShift, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(0.0, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(-distanceToShift, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getY(), epsilon);

      // Pointing straight along x:
      lineSegment = new LineSegment2D(0.0, 0.0, 1.0, 0.0);
      shiftedLineSegment = lineSegment.shiftToRightCopy(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(0.0, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(-distanceToShift, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(-distanceToShift, secondShiftedEndpoint.getY(), epsilon);

      shiftedLineSegment = lineSegment.shiftToLeftCopy(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(0.0, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(distanceToShift, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(distanceToShift, secondShiftedEndpoint.getY(), epsilon);

      // Pointing at (1,1)
      lineSegment = new LineSegment2D(0.0, 0.0, 1.0, 1.0);
      shiftedLineSegment = lineSegment.shiftToRightCopy(distanceToShift);
      double distanceAtFortyFiveDegrees = distanceToShift * Math.sqrt(2.0) / 2.0;

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(distanceAtFortyFiveDegrees, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(-distanceAtFortyFiveDegrees, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0 + distanceAtFortyFiveDegrees, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0 - distanceAtFortyFiveDegrees, secondShiftedEndpoint.getY(), epsilon);

      shiftedLineSegment = lineSegment.shiftToLeftCopy(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(-distanceAtFortyFiveDegrees, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(distanceAtFortyFiveDegrees, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0 - distanceAtFortyFiveDegrees, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0 + distanceAtFortyFiveDegrees, secondShiftedEndpoint.getY(), epsilon);
   }

   @Test
   public void testShiftToLeftAndRight()
   {
      double distanceToShift = 0.2;
      double epsilon = 1e-7;

      // Pointing straight up:
      LineSegment2D lineSegment = new LineSegment2D(0.0, 0.0, 0.0, 1.0);
      LineSegment2D shiftedLineSegment = new LineSegment2D(lineSegment);
      shiftedLineSegment.shiftToRight(distanceToShift);

      Point2D firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      Point2D secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(distanceToShift, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(0.0, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(distanceToShift, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getY(), epsilon);

      shiftedLineSegment.set(lineSegment);
      shiftedLineSegment.shiftToLeft(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(-distanceToShift, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(0.0, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(-distanceToShift, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getY(), epsilon);

      // Pointing straight along x:
      lineSegment = new LineSegment2D(0.0, 0.0, 1.0, 0.0);
      shiftedLineSegment.set(lineSegment);
      shiftedLineSegment.shiftToRight(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(0.0, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(-distanceToShift, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(-distanceToShift, secondShiftedEndpoint.getY(), epsilon);

      shiftedLineSegment.set(lineSegment);
      shiftedLineSegment.shiftToLeft(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(0.0, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(distanceToShift, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(distanceToShift, secondShiftedEndpoint.getY(), epsilon);

      // Pointing at (1,1)
      lineSegment = new LineSegment2D(0.0, 0.0, 1.0, 1.0);
      shiftedLineSegment.set(lineSegment);
      shiftedLineSegment.shiftToRight(distanceToShift);

      double distanceAtFortyFiveDegrees = distanceToShift * Math.sqrt(2.0) / 2.0;

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(distanceAtFortyFiveDegrees, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(-distanceAtFortyFiveDegrees, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0 + distanceAtFortyFiveDegrees, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0 - distanceAtFortyFiveDegrees, secondShiftedEndpoint.getY(), epsilon);

      shiftedLineSegment.set(lineSegment);
      shiftedLineSegment.shiftToLeft(distanceToShift);

      firstShiftedEndpoint = shiftedLineSegment.getFirstEndpointCopy();
      secondShiftedEndpoint = shiftedLineSegment.getSecondEndpointCopy();

      assertEquals(-distanceAtFortyFiveDegrees, firstShiftedEndpoint.getX(), epsilon);
      assertEquals(distanceAtFortyFiveDegrees, firstShiftedEndpoint.getY(), epsilon);
      assertEquals(1.0 - distanceAtFortyFiveDegrees, secondShiftedEndpoint.getX(), epsilon);
      assertEquals(1.0 + distanceAtFortyFiveDegrees, secondShiftedEndpoint.getY(), epsilon);
   }

   @Test
   public void testIsPointOnLeftRightSide()
   {
      LineSegment2D lineSegment = new LineSegment2D(0.0, 0.0, 0.0, 1.0);

      Point2D point = new Point2D(0.1, 0.5);
      assertFalse(lineSegment.isPointOnLeftSideOfLineSegment(point));
      assertTrue(lineSegment.isPointOnRightSideOfLineSegment(point));

      point = new Point2D(-0.1, 0.5);
      assertTrue(lineSegment.isPointOnLeftSideOfLineSegment(point));
      assertFalse(lineSegment.isPointOnRightSideOfLineSegment(point));

      lineSegment = new LineSegment2D(0.0, 2.0, 4.0, 6.0);

      point = new Point2D(0.0, 0.0);
      assertTrue(lineSegment.isPointOnRightSideOfLineSegment(point));

      point = new Point2D(4.1, 6.0);
      assertTrue(lineSegment.isPointOnRightSideOfLineSegment(point));

      point = new Point2D(3.9, 6.0);
      assertTrue(lineSegment.isPointOnLeftSideOfLineSegment(point));

   }

   @Test
   public void testOrthogonalProjectionCopyPoint2dLineSegment2d()
   {
      Point2D startPoint = new Point2D(-10.0, 0.0);
      Point2D endPoint = new Point2D(10.0, 0.0);
      LineSegment2D line1 = new LineSegment2D(startPoint, endPoint);

      Point2D origionalPoint = new Point2D(-20.0, 10.0);
      Point2D projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(startPoint, projectedPoint);

      origionalPoint = new Point2D(-20.0, -10.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(startPoint, projectedPoint);

      origionalPoint = new Point2D(-20.0, 0.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(startPoint, projectedPoint);

      origionalPoint = new Point2D(20.0, 10.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(endPoint, projectedPoint);

      origionalPoint = new Point2D(20.0, -10.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(endPoint, projectedPoint);

      origionalPoint = new Point2D(20.0, 0.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(endPoint, projectedPoint);

      origionalPoint = new Point2D(0.0, 10.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(new Point2D(0.0, 0.0), projectedPoint);

      origionalPoint = new Point2D(0.0, -10.0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(new Point2D(0.0, 0.0), projectedPoint);

      origionalPoint = new Point2D(5.0, 0);
      projectedPoint = line1.orthogonalProjectionCopy(origionalPoint);
      assertEquals(new Point2D(5.0, 0.0), projectedPoint);

      Random random = new Random(2342L);

      for (int i = 0; i < 1000; i++)
      {
         Point2D lineSegmentStart = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         Point2D lineSegmentEnd = EuclidCoreRandomTools.generateRandomPoint2D(random, -10.0, 10.0);
         LineSegment2D lineSegment = new LineSegment2D(lineSegmentStart, lineSegmentEnd);
         Vector2D orthogonal = new Vector2D();
         orthogonal.sub(lineSegmentEnd, lineSegmentStart);
         EuclidGeometryTools.perpendicularVector2D(orthogonal, orthogonal);
         orthogonal.normalize();
         Point2D expectedProjection = new Point2D();
         Point2D testPoint = new Point2D();

         // Between end points
         expectedProjection.interpolate(lineSegmentStart, lineSegmentEnd, EuclidCoreRandomTools.generateRandomDouble(random, 0.0, 1.0));
         testPoint.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 10.0), orthogonal, expectedProjection);
         Point2D actualProjection = lineSegment.orthogonalProjectionCopy(testPoint);
         EuclidCoreTestTools.assertTuple2DEquals(expectedProjection, actualProjection, EuclidGeometryTools.ONE_TRILLIONTH);

         // Before end points
         expectedProjection.interpolate(lineSegmentStart, lineSegmentEnd, EuclidCoreRandomTools.generateRandomDouble(random, -10.0, 0.0));
         testPoint.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 10.0), orthogonal, expectedProjection);
         expectedProjection.set(lineSegmentStart);
         actualProjection = lineSegment.orthogonalProjectionCopy(testPoint);
         EuclidCoreTestTools.assertTuple2DEquals(expectedProjection, actualProjection, EuclidGeometryTools.ONE_TRILLIONTH);

         // After end points
         expectedProjection.interpolate(lineSegmentStart, lineSegmentEnd, EuclidCoreRandomTools.generateRandomDouble(random, 1.0, 10.0));
         testPoint.scaleAdd(EuclidCoreRandomTools.generateRandomDouble(random, 10.0), orthogonal, expectedProjection);
         expectedProjection.set(lineSegmentEnd);
         actualProjection = lineSegment.orthogonalProjectionCopy(testPoint);
         EuclidCoreTestTools.assertTuple2DEquals(expectedProjection, actualProjection, EuclidGeometryTools.ONE_TRILLIONTH);
      }
   }

   @Test
   public void testIntersectionLine2dLineSegment2d()
   {
      double epsilon = EuclidGeometryTools.ONE_TRILLIONTH;

      LineSegment2D line1 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      Line2D line2 = new Line2D(new Point2D(-10.0, 10.0), new Point2D(10.0, 0.0));
      Line2D line3 = new Line2D(new Point2D(0.0, 10.0), new Point2D(0.0, -10.0));
      Line2D line4 = new Line2D(new Point2D(0.0, -10.0), new Point2D(0.0, 10.0));
      Line2D line5 = new Line2D(new Point2D(-10.0, 0.0), new Point2D(10.0, 0.0));
      Line2D line6 = new Line2D(new Point2D(10.0, 0.0), new Point2D(-10.0, 0.0));
      Line2D line7 = new Line2D(new Point2D(10.0, 0.0), new Point2D(20.0, 0.0));
      Line2D line8 = new Line2D(new Point2D(10.0, 0.0), new Point2D(-20.0, 0.0));
      Line2D line9 = new Line2D(new Point2D(10.1, 0.0), new Point2D(20.0, 0.0));
      Line2D line10 = new Line2D(new Point2D(10.0, 0.0), new Point2D(20.0, 1.0));

      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line5), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line6), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line2), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line10), epsilon);

      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(0.0, 0.0), line1.intersectionWith(line3), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(0.0, 0.0), line1.intersectionWith(line4), epsilon);

      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line7), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line8), epsilon);
      EuclidCoreTestTools.assertTuple2DEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line9), epsilon);
   }

   @Test
   public void testIntersectionLineSegment2dLineSegment2d()
   {
      Point2D colTestp1 = new Point2D(1.5, -5);
      Point2D colTestp2 = new Point2D(1.5, 0);
      Point2D colTestp3 = new Point2D(1.5, 5);

      LineSegment2D colTestLine1 = new LineSegment2D(colTestp1, colTestp2);
      LineSegment2D colTestLine2 = new LineSegment2D(colTestp2, colTestp1);

      LineSegment2D colTestLine3 = new LineSegment2D(colTestp1, colTestp3);
      LineSegment2D colTestLine4 = new LineSegment2D(colTestp3, colTestp1);

      LineSegment2D colTestLine5 = new LineSegment2D(colTestp2, colTestp3);
      LineSegment2D colTestLine6 = new LineSegment2D(colTestp3, colTestp2);

      assertEquals(colTestp2, colTestLine1.intersectionWith(colTestLine2));
      assertEquals(colTestp1, colTestLine1.intersectionWith(colTestLine3));
      assertEquals(colTestp1, colTestLine1.intersectionWith(colTestLine4));
      assertEquals(colTestp1, colTestLine2.intersectionWith(colTestLine4));

      assertEquals(colTestp2, colTestLine1.intersectionWith(colTestLine5));
      assertEquals(colTestp2, colTestLine2.intersectionWith(colTestLine6));

      LineSegment2D line1 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      LineSegment2D line2 = new LineSegment2D(-10.0, 10.0, 10.0, 0.0);
      LineSegment2D line3 = new LineSegment2D(0.0, 10.0, 0.0, -10.0);
      LineSegment2D line4 = new LineSegment2D(0.0, -10.0, 0.0, 10.0);
      LineSegment2D line5 = new LineSegment2D(-10.0, 0.0, 10.0, 0.0);
      LineSegment2D line6 = new LineSegment2D(10.0, 0.0, -10.0, 0.0);
      LineSegment2D line7 = new LineSegment2D(10.0, 0.0, 20.0, 0.0);
      LineSegment2D line8 = new LineSegment2D(10.0, 0.0, -20.0, 0.0);
      LineSegment2D line9 = new LineSegment2D(10.1, 0.0, 20.0, 0.0);

      assertEquals(new Point2D(-10.0, 0.0), line5.intersectionWith(line1));
      assertEquals(new Point2D(-10.0, 0.0), line1.intersectionWith(line5));

      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line6));

      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line2));
      assertEquals(new Point2D(0.0, 0.0), line1.intersectionWith(line3));
      assertEquals(new Point2D(0.0, 0.0), line1.intersectionWith(line4));

      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line7));
      assertEquals(new Point2D(10.0, 0.0), line1.intersectionWith(line8));
      assertEquals(null, line1.intersectionWith(line9));
   }

}
