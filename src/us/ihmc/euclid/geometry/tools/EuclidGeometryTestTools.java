package us.ihmc.euclid.geometry.tools;

import static us.ihmc.euclid.geometry.tools.EuclidGeometryIOTools.*;
import static us.ihmc.euclid.tools.EuclidCoreIOTools.getStringFormat;

import us.ihmc.euclid.geometry.BoundingBox2D;
import us.ihmc.euclid.geometry.BoundingBox3D;
import us.ihmc.euclid.geometry.Line3D;
import us.ihmc.euclid.geometry.LineSegment3D;

public class EuclidGeometryTestTools
{
   private static final String DEFAULT_FORMAT = getStringFormat(15, 12);

   /**
    * Asserts on a per component basis that the two line 3Ds are equal to an {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param expected the expected line 3D.
    * @param actual the actual line 3D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two line 3Ds are not equal. If only one of the arguments is
    *            equal to {@code null}.
    */
   public static void assertLine3DEquals(Line3D expected, Line3D actual, double epsilon)
   {
      assertLine3DEquals(null, expected, actual, epsilon);
   }

   /**
    * Asserts on a per component basis that the two line 3Ds are equal to an {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected line 3D.
    * @param actual the actual line 3D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two line 3Ds are not equal. If only one of the arguments is
    *            equal to {@code null}.
    */
   public static void assertLine3DEquals(String messagePrefix, Line3D expected, Line3D actual, double epsilon)
   {
      assertLine3DEquals(messagePrefix, expected, actual, epsilon, DEFAULT_FORMAT);
   }

   /**
    * Asserts on a per component basis that the two line 3Ds are equal to an {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected line 3D.
    * @param actual the actual line 3D.
    * @param epsilon the tolerance to use.
    * @param format the format to use for printing each component when an {@code AssertionError} is
    *           thrown.
    * @throws AssertionError if the two line 3Ds are not equal. If only one of the arguments is
    *            equal to {@code null}.
    */
   public static void assertLine3DEquals(String messagePrefix, Line3D expected, Line3D actual, double epsilon, String format)
   {
      if (expected == null && actual == null)
         return;

      if (!(expected != null && actual != null))
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);

      if (!expected.epsilonEquals(actual, epsilon))
      {
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);
      }
   }

   /**
    * Asserts on a per component basis that the two line segment 3Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param expected the expected line segment 3D.
    * @param actual the actual line segment 3D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two line segment 3Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertLineSegment3DEquals(LineSegment3D expected, LineSegment3D actual, double epsilon)
   {
      assertLineSegment3DEquals(null, expected, actual, epsilon);
   }

   /**
    * Asserts on a per component basis that the two line segment 3Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected line segment 3D.
    * @param actual the actual line segment 3D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two line segment 3Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertLineSegment3DEquals(String messagePrefix, LineSegment3D expected, LineSegment3D actual, double epsilon)
   {
      assertLineSegment3DEquals(messagePrefix, expected, actual, epsilon, DEFAULT_FORMAT);
   }

   /**
    * Asserts on a per component basis that the two line segment 3Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected line segment 3D.
    * @param actual the actual line segment 3D.
    * @param epsilon the tolerance to use.
    * @param format the format to use for printing each component when an {@code AssertionError} is
    *           thrown.
    * @throws AssertionError if the two line segment 3Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertLineSegment3DEquals(String messagePrefix, LineSegment3D expected, LineSegment3D actual, double epsilon, String format)
   {
      if (expected == null && actual == null)
         return;

      if (!(expected != null && actual != null))
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);

      if (!expected.epsilonEquals(actual, epsilon))
      {
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);
      }
   }

   /**
    * Asserts on a per component basis that the two bounding box 2Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param expected the expected bounding box 2D.
    * @param actual the actual bounding box 2D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two bounding box 2Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertBoundingBox2DEquals(BoundingBox2D expected, BoundingBox2D actual, double epsilon)
   {
      assertBoundingBox2DEquals(null, expected, actual, epsilon);
   }

   /**
    * Asserts on a per component basis that the two bounding box 2Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected bounding box 2D.
    * @param actual the actual bounding box 2D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two bounding box 2Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertBoundingBox2DEquals(String messagePrefix, BoundingBox2D expected, BoundingBox2D actual, double epsilon)
   {
      assertBoundingBox2DEquals(messagePrefix, expected, actual, epsilon, DEFAULT_FORMAT);
   }

   /**
    * Asserts on a per component basis that the two bounding box 2Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected bounding box 2D.
    * @param actual the actual bounding box 2D.
    * @param epsilon the tolerance to use.
    * @param format the format to use for printing each component when an {@code AssertionError} is
    *           thrown.
    * @throws AssertionError if the two bounding box 2Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertBoundingBox2DEquals(String messagePrefix, BoundingBox2D expected, BoundingBox2D actual, double epsilon, String format)
   {
      if (expected == null && actual == null)
         return;

      if (!(expected != null && actual != null))
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);

      if (!expected.epsilonEquals(actual, epsilon))
      {
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);
      }
   }

   /**
    * Asserts on a per component basis that the two bounding box 3Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param expected the expected bounding box 3D.
    * @param actual the actual bounding box 3D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two bounding box 3Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertBoundingBox3DEquals(BoundingBox3D expected, BoundingBox3D actual, double epsilon)
   {
      assertBoundingBox3DEquals(null, expected, actual, epsilon);
   }

   /**
    * Asserts on a per component basis that the two bounding box 3Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected bounding box 3D.
    * @param actual the actual bounding box 3D.
    * @param epsilon the tolerance to use.
    * @throws AssertionError if the two bounding box 3Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertBoundingBox3DEquals(String messagePrefix, BoundingBox3D expected, BoundingBox3D actual, double epsilon)
   {
      assertBoundingBox3DEquals(messagePrefix, expected, actual, epsilon, DEFAULT_FORMAT);
   }

   /**
    * Asserts on a per component basis that the two bounding box 3Ds are equal to an
    * {@code epsilon}.
    * <p>
    * Note: the two arguments are considered to be equal if they are both equal to {@code null}.
    * </p>
    *
    * @param messagePrefix prefix to add to the error message.
    * @param expected the expected bounding box 3D.
    * @param actual the actual bounding box 3D.
    * @param epsilon the tolerance to use.
    * @param format the format to use for printing each component when an {@code AssertionError} is
    *           thrown.
    * @throws AssertionError if the two bounding box 3Ds are not equal. If only one of the arguments
    *            is equal to {@code null}.
    */
   public static void assertBoundingBox3DEquals(String messagePrefix, BoundingBox3D expected, BoundingBox3D actual, double epsilon, String format)
   {
      if (expected == null && actual == null)
         return;

      if (!(expected != null && actual != null))
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);

      if (!expected.epsilonEquals(actual, epsilon))
      {
         throwNotEqualAssertionError(messagePrefix, expected, actual, format);
      }
   }

   private static void throwNotEqualAssertionError(String messagePrefix, Line3D expected, Line3D actual, String format)
   {
      String expectedAsString = getLine3DString(format, expected);
      String actualAsString = getLine3DString(format, actual);
      throwNotEqualAssertionError(messagePrefix, expectedAsString, actualAsString);
   }

   private static void throwNotEqualAssertionError(String messagePrefix, LineSegment3D expected, LineSegment3D actual, String format)
   {
      String expectedAsString = getLineSegment3DString(format, expected);
      String actualAsString = getLineSegment3DString(format, actual);
      throwNotEqualAssertionError(messagePrefix, expectedAsString, actualAsString);
   }

   private static void throwNotEqualAssertionError(String messagePrefix, BoundingBox2D expected, BoundingBox2D actual, String format)
   {
      String expectedAsString = getBoundingBox2DString(format, expected);
      String actualAsString = getBoundingBox2DString(format, actual);
      throwNotEqualAssertionError(messagePrefix, expectedAsString, actualAsString);
   }

   private static void throwNotEqualAssertionError(String messagePrefix, BoundingBox3D expected, BoundingBox3D actual, String format)
   {
      String expectedAsString = getBoundingBox3DString(format, expected);
      String actualAsString = getBoundingBox3DString(format, actual);
      throwNotEqualAssertionError(messagePrefix, expectedAsString, actualAsString);
   }

   private static void throwNotEqualAssertionError(String messagePrefix, String expectedAsString, String actualAsString)
   {
      throwNotEqualAssertionError(messagePrefix, expectedAsString, actualAsString, null);
   }

   private static void throwNotEqualAssertionError(String messagePrefix, String expectedAsString, String actualAsString, String differenceAsString)
   {
      String errorMessage = addPrefixToMessage(messagePrefix, "expected:\n" + expectedAsString + "\n but was:\n" + actualAsString);
      if (differenceAsString != null)
         errorMessage += "\nDifference of: " + differenceAsString;

      throw new AssertionError(errorMessage);
   }

   private static String addPrefixToMessage(String prefix, String message)
   {
      if (prefix != null && !prefix.isEmpty())
         return prefix + " " + message;
      else
         return message;
   }
}
