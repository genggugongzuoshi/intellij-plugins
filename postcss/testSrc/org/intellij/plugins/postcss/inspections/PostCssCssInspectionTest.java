package org.intellij.plugins.postcss.inspections;

import com.intellij.psi.css.inspections.invalid.CssInvalidImportInspection;
import com.intellij.psi.css.inspections.invalid.CssInvalidMediaFeatureInspection;
import com.intellij.psi.css.inspections.invalid.CssInvalidPseudoSelectorInspection;
import com.intellij.testFramework.TestDataPath;
import org.intellij.plugins.postcss.PostCssFixtureTestCase;

@TestDataPath("$CONTENT_ROOT/testData/inspections/")
public class PostCssCssInspectionTest extends PostCssFixtureTestCase {

  @Override
  public void setUp() throws Exception {
    super.setUp();
    myFixture.enableInspections(CssInvalidImportInspection.class,
                                CssInvalidPseudoSelectorInspection.class,
                                CssInvalidMediaFeatureInspection.class);
  }

  public void testImportEverywhere() {
    doTest();
  }

  public void testInvalidPseudoClass() {
    doTest();
  }

  public void testMediaFeatureInvalid() {
    doTest();
  }

  private long doTest() {
    return myFixture.testHighlighting(true, false, false, getTestName(true) + ".pcss");
  }
}