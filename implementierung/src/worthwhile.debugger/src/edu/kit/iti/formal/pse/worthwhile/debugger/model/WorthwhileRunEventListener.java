package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

public class WorthwhileRunEventListener extends WorthwhileEventListener {

    public WorthwhileRunEventListener(final WorthwhileDebugTarget debugTarget) {
	super(debugTarget);
    }

    @Override
    public final void statementWillExecute(final Statement statement) {
	// TODO Auto-generated method stub
	super.statementWillExecute(statement);
    }

    @Override
    public final void executionCompleted() {
	// TODO Auto-generated method stub
	super.executionCompleted();
    }

    @Override
    public final void assertionFailed(final Assertion assertion) {
	// TODO Auto-generated method stub
	super.assertionFailed(assertion);
    }

}
