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

    void visitBegin(Block node, AstVisitorArgs args) throws Exception;

    void visitEnd(Block node) throws Exception;

    void visitBegin(CollectionStmt node, AstVisitorArgs args) throws Exception;

    void visitEnd(CollectionStmt node) throws Exception;

    void visitBegin(ConditionStmt node, AstVisitorArgs args) throws Exception;

    void visitEnd(ConditionStmt node) throws Exception;

    void visitBegin(SingleVariableStmt node, AstVisitorArgs args) throws Exception;

    void visitEnd(SingleVariableStmt node) throws Exception;

    void visitBegin(SequenceVariableStmt node, AstVisitorArgs args) throws Exception;

    void visitEnd(SequenceVariableStmt node) throws Exception;

    void visitBegin(ArgumentVariableStmt node, AstVisitorArgs args) throws Exception;

    void visitEnd(ArgumentVariableStmt node) throws Exception;

    void visitBegin(CollectionExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(CollectionExp node) throws Exception;

    void visitBegin(ArgumentExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(ArgumentExp node) throws Exception;

    void visitBegin(SingleVariableDefExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(SingleVariableDefExp node) throws Exception;

    void visitBegin(SingleVariableExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(SingleVariableExp node) throws Exception;

    void visitBegin(SequenceVariableDefExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(SequenceVariableDefExp node) throws Exception;

    void visitBegin(SequenceVariableExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(SequenceVariableExp node) throws Exception;

    void visitBegin(ArgumentVariableDefExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(ArgumentVariableDefExp node) throws Exception;

    void visitBegin(ArgumentVariableExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(ArgumentVariableExp node) throws Exception;

    void visitBegin(Sinop node, AstVisitorArgs args) throws Exception;

    void visitEnd(Sinop node) throws Exception;

    void visitBegin(Binop node, AstVisitorArgs args) throws Exception;

    void visitEnd(Binop node) throws Exception;

    void visitBegin(TokenExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(TokenExp node) throws Exception;

    void visitBegin(QuantifierExp node, AstVisitorArgs args) throws Exception;

    void visitEnd(QuantifierExp node) throws Exception;

    void visitBegin(TId node) throws Exception;

    void visitEnd(TId node) throws Exception;

    void visitBegin(TLiteral node) throws Exception;

    void visitEnd(TLiteral node) throws Exception;

    void visitBegin(TNumber node) throws Exception;

    void visitEnd(TNumber node) throws Exception;

    void visitBegin(TRange node) throws Exception;

    void visitEnd(TRange node) throws Exception;
}
