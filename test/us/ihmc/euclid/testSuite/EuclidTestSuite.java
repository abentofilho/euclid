package us.ihmc.euclid.testSuite;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.pitest.mutationtest.commandline.MutationCoverageReport;

import us.ihmc.euclid.geometry.BoundingBox2DTest;
import us.ihmc.euclid.geometry.BoundingBox3DTest;
import us.ihmc.euclid.geometry.ConvexPolygon2DTest;
import us.ihmc.euclid.geometry.Line2DTest;
import us.ihmc.euclid.geometry.Line3DTest;
import us.ihmc.euclid.geometry.LineSegment1DTest;
import us.ihmc.euclid.geometry.LineSegment2DTest;
import us.ihmc.euclid.geometry.LineSegment3DTest;
import us.ihmc.euclid.geometry.tools.EuclidGeometryPolygonToolsTest;
import us.ihmc.euclid.geometry.tools.EuclidGeometryToolsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
      // Geometry class tests
      // 1D
      LineSegment1DTest.class,
      // 2D
      Line2DTest.class, LineSegment2DTest.class, ConvexPolygon2DTest.class, BoundingBox2DTest.class,
      // 3D
      Line3DTest.class, LineSegment3DTest.class, BoundingBox3DTest.class,
      // Tools tests
      EuclidGeometryToolsTest.class, EuclidGeometryPolygonToolsTest.class})

public class EuclidTestSuite
{
   public static void main(String[] args) throws URISyntaxException, IOException
   {
      String targetTests = EuclidTestSuite.class.getName();
      String targetClasses = "us.ihmc.euclid.*";
      doPITMutationTestAndOpenResult(targetTests, targetClasses);
   }

   public static void doPITMutationTestAndOpenResult(String targetTests, String targetClasses)
   {
      String reportDirectoryName = "pit-reports";
      MutationCoverageReport.main(new String[] {"--reportDir", reportDirectoryName, "--targetClasses", targetClasses, "--targetTests", targetTests,
            "--sourceDirs", "src,test"});

      File reportDirectory = new File(reportDirectoryName);
      if (reportDirectory.isDirectory() && reportDirectory.exists())
      {
         String[] list = reportDirectory.list();
         String lastDirectoryName = list[list.length - 1];

         System.out.println("Found last directory " + lastDirectoryName);

         File reportFile = new File(reportDirectory, lastDirectoryName + "/index.html");
         String absolutePath;
         try
         {
            absolutePath = reportFile.getCanonicalPath();

            absolutePath = absolutePath.replace("\\", "/");
            System.out.println("Opening " + "file://" + absolutePath);

            URI uri = new URI("file://" + absolutePath);
            Desktop.getDesktop().browse(uri);
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
         catch (URISyntaxException e)
         {
            e.printStackTrace();
         }
      }
   }
}