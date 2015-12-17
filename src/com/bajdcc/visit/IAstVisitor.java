package com.bajdcc.visit;

import com.bajdcc.ast.block.Block;
import com.bajdcc.ast.exp.*;
import com.bajdcc.ast.stmt.*;
import com.bajdcc.ast.token.TId;
import com.bajdcc.ast.token.TLiteral;
import com.bajdcc.ast.token.TNumber;
import com.bajdcc.ast.token.TRange;

/**
 * 访问者
 */
public interface IAstVisitor {

    void visitBegin(Block node, AstVisitorArgs args);

    void visitEnd(Block node);

    void visitBegin(CollectionStmt node, AstVisitorArgs args);

    void visitEnd(CollectionStmt node);

    void visitBegin(ConditionStmt node, AstVisitorArgs args);

    void visitEnd(ConditionStmt node);

    void visitBegin(SingleVariableStmt node, AstVisitorArgs args);

    void visitEnd(SingleVariableStmt node);

    void visitBegin(SequenceVariableStmt node, AstVisitorArgs args);

    void visitEnd(SequenceVariableStmt node);

    void visitBegin(ArgumentVariableStmt node, AstVisitorArgs args);

    void visitEnd(ArgumentVariableStmt node);

    void visitBegin(CollectionExp node, AstVisitorArgs args);

    void visitEnd(CollectionExp node);

    void visitBegin(ArgumentExp node, AstVisitorArgs args);

    void visitEnd(ArgumentExp node);

    void visitBegin(SingleVariableDefExp node, AstVisitorArgs args);

    void visitEnd(SingleVariableDefExp node);

    void visitBegin(SingleVariableExp node, AstVisitorArgs args);

    void visitEnd(SingleVariableExp node);

    void visitBegin(SequenceVariableDefExp node, AstVisitorArgs args);

    void visitEnd(SequenceVariableDefExp node);

    void visitBegin(SequenceVariableExp node, AstVisitorArgs args);

    void visitEnd(SequenceVariableExp node);

    void visitBegin(ArgumentVariableDefExp node, AstVisitorArgs args);

    void visitEnd(ArgumentVariableDefExp node);

    void visitBegin(ArgumentVariableExp node, AstVisitorArgs args);

    void visitEnd(ArgumentVariableExp node);

    void visitBegin(Sinop node, AstVisitorArgs args);

    void visitEnd(Sinop node);

    void visitBegin(Binop node, AstVisitorArgs args);

    void visitEnd(Binop node);

    void visitBegin(TokenExp node, AstVisitorArgs args);

    void visitEnd(TokenExp node);

    void visitBegin(QuantifierExp node, AstVisitorArgs args);

    void visitEnd(QuantifierExp node);

    void visitBegin(TId node);

    void visitEnd(TId node);

    void visitBegin(TLiteral node);

    void visitEnd(TLiteral node);

    void visitBegin(TNumber node);

    void visitEnd(TNumber node);

    void visitBegin(TRange node);

    void visitEnd(TRange node);
}
