package ro.redeul.google.go.inspection.fix;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import ro.redeul.google.go.GoEditorAwareTestCase;
import ro.redeul.google.go.lang.psi.GoFile;
import ro.redeul.google.go.lang.psi.toplevel.GoFunctionDeclaration;

import static ro.redeul.google.go.lang.psi.utils.GoPsiUtils.findParentOfType;

public class AddReturnStmtFixTest extends GoEditorAwareTestCase {
    public void testSimple() throws Exception{ doTest(); }

    @Override
    protected void invoke(Project project, Editor editor, GoFile file) {
        PsiElement element = file.findElementAt(editor.getSelectionModel().getSelectionStart());
        GoFunctionDeclaration function = findParentOfType(element, GoFunctionDeclaration.class);
        assertNotNull(function);

        new AddReturnStmtFix(function).invoke(project, file, editor, function, function);
    }

    @Override
    protected String getTestDataRelativePath() {
        return "fixes/addReturnStmt/";
    }
}
