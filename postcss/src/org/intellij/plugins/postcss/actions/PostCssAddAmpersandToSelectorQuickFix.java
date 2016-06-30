package org.intellij.plugins.postcss.actions;

import com.intellij.codeInspection.LocalQuickFixBase;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.css.CssSelector;
import com.intellij.psi.css.impl.CssSimpleSelectorImpl;
import org.intellij.plugins.postcss.PostCssBundle;
import org.intellij.plugins.postcss.psi.PostCssElementGenerator;
import org.jetbrains.annotations.NotNull;

public class PostCssAddAmpersandToSelectorQuickFix extends LocalQuickFixBase {
  public PostCssAddAmpersandToSelectorQuickFix() {
    super(PostCssBundle.message("annotator.add.ampersand.quickfix.name"));
  }

    @Override
  public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
    CssSimpleSelectorImpl ampersand = PostCssElementGenerator.createAmpersand(project);
    if (ampersand == null) return;
    PsiElement startElement = descriptor.getStartElement();
    if (startElement instanceof CssSelector) {
      CssSelector selector = (CssSelector)startElement;
      if (selector.getSimpleSelectors().length == 0) return;
      selector.addBefore(ampersand, selector.getSimpleSelectors()[0]);
    }
  }
}