package triangle.optimiser;

import triangle.StdEnvironment;
import triangle.abstractSyntaxTrees.AbstractSyntaxTree;
import triangle.abstractSyntaxTrees.Program;
import triangle.abstractSyntaxTrees.actuals.*;
import triangle.abstractSyntaxTrees.aggregates.MultipleArrayAggregate;
import triangle.abstractSyntaxTrees.aggregates.MultipleRecordAggregate;
import triangle.abstractSyntaxTrees.aggregates.SingleArrayAggregate;
import triangle.abstractSyntaxTrees.aggregates.SingleRecordAggregate;
import triangle.abstractSyntaxTrees.commands.*;
import triangle.abstractSyntaxTrees.declarations.*;
import triangle.abstractSyntaxTrees.expressions.*;
import triangle.abstractSyntaxTrees.formals.*;
import triangle.abstractSyntaxTrees.terminals.CharacterLiteral;
import triangle.abstractSyntaxTrees.terminals.Identifier;
import triangle.abstractSyntaxTrees.terminals.IntegerLiteral;
import triangle.abstractSyntaxTrees.terminals.Operator;
import triangle.abstractSyntaxTrees.types.*;
import triangle.abstractSyntaxTrees.visitors.*;
import triangle.abstractSyntaxTrees.vnames.DotVname;
import triangle.abstractSyntaxTrees.vnames.SimpleVname;
import triangle.abstractSyntaxTrees.vnames.SubscriptVname;

public class ConstantFolderWithStats extends ConstantFolder implements ActualParameterVisitor<Void, AbstractSyntaxTree>,
		ActualParameterSequenceVisitor<Void, AbstractSyntaxTree>, ArrayAggregateVisitor<Void, AbstractSyntaxTree>,
		CommandVisitor<Void, AbstractSyntaxTree>, DeclarationVisitor<Void, AbstractSyntaxTree>,
		ExpressionVisitor<Void, AbstractSyntaxTree>, FormalParameterSequenceVisitor<Void, AbstractSyntaxTree>,
		IdentifierVisitor<Void, AbstractSyntaxTree>, LiteralVisitor<Void, AbstractSyntaxTree>,
		OperatorVisitor<Void, AbstractSyntaxTree>, ProgramVisitor<Void, AbstractSyntaxTree>,
		RecordAggregateVisitor<Void, AbstractSyntaxTree>, TypeDenoterVisitor<Void, AbstractSyntaxTree>,
		VnameVisitor<Void, AbstractSyntaxTree> {
    private int integerExpressions;
	private int characterExpressions;

    {
		this.characterExpressions = 0;
		this.integerExpressions = 0;
	}

	public int getCharacterExpressions() {
		return characterExpressions;
	}

	public int getIntegerExpressions() {
		return integerExpressions;
	}

	@Override
	public AbstractSyntaxTree visitCharacterExpression(CharacterExpression ast, Void arg) {
		ast.CL.visit(this);
		characterExpressions++;
		return null;
	}

	@Override
	public AbstractSyntaxTree visitIntegerExpression(IntegerExpression ast, Void arg)
	{
		integerExpressions++;
		return ast;
	}

}
