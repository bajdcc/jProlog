package com.bajdcc.rt;

import com.bajdcc.ast.block.Block;
import com.bajdcc.ast.exp.*;
import com.bajdcc.ast.stmt.*;
import com.bajdcc.ast.token.TId;
import com.bajdcc.ast.token.TLiteral;
import com.bajdcc.ast.token.TNumber;
import com.bajdcc.ast.token.TRange;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstVisitor;

import java.util.List;

/**
 * 块
 */
public class RtBlock implements IAstVisitor {

    private List<CollectionStmt> set;
    private List<SingleVariableStmt> sin;
    private List<ArgumentVariableStmt> arg;
    private List<SequenceVariableStmt> seq;
    private List<ConditionStmt> cond;

    public List<CollectionStmt> getSet() {
        return set;
    }

    public List<SingleVariableStmt> getSin() {
        return sin;
    }

    public List<ArgumentVariableStmt> getArg() {
        return arg;
    }

    public List<SequenceVariableStmt> getSeq() {
        return seq;
    }

    public List<ConditionStmt> getCond() {
        return cond;
    }

    @Override
    public void visitBegin(Block node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(Block node) {

    }

    @Override
    public void visitBegin(CollectionStmt node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(CollectionStmt node) {

    }

    @Override
    public void visitBegin(ConditionStmt node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(ConditionStmt node) {

    }

    @Override
    public void visitBegin(SingleVariableStmt node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(SingleVariableStmt node) {

    }

    @Override
    public void visitBegin(SequenceVariableStmt node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(SequenceVariableStmt node) {

    }

    @Override
    public void visitBegin(ArgumentVariableStmt node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(ArgumentVariableStmt node) {

    }

    @Override
    public void visitBegin(CollectionExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(CollectionExp node) {

    }

    @Override
    public void visitBegin(ArgumentExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(ArgumentExp node) {

    }

    @Override
    public void visitBegin(SingleVariableDefExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(SingleVariableDefExp node) {

    }

    @Override
    public void visitBegin(SingleVariableExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(SingleVariableExp node) {

    }

    @Override
    public void visitBegin(SequenceVariableDefExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(SequenceVariableDefExp node) {

    }

    @Override
    public void visitBegin(SequenceVariableExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(SequenceVariableExp node) {

    }

    @Override
    public void visitBegin(ArgumentVariableDefExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(ArgumentVariableDefExp node) {

    }

    @Override
    public void visitBegin(ArgumentVariableExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(ArgumentVariableExp node) {

    }

    @Override
    public void visitBegin(Sinop node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(Sinop node) {

    }

    @Override
    public void visitBegin(Binop node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(Binop node) {

    }

    @Override
    public void visitBegin(TokenExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(TokenExp node) {

    }

    @Override
    public void visitBegin(QuantifierExp node, AstVisitorArgs args) {

    }

    @Override
    public void visitEnd(QuantifierExp node) {

    }

    @Override
    public void visitBegin(TId node) {

    }

    @Override
    public void visitEnd(TId node) {

    }

    @Override
    public void visitBegin(TLiteral node) {

    }

    @Override
    public void visitEnd(TLiteral node) {

    }

    @Override
    public void visitBegin(TNumber node) {

    }

    @Override
    public void visitEnd(TNumber node) {

    }

    @Override
    public void visitBegin(TRange node) {

    }

    @Override
    public void visitEnd(TRange node) {

    }
}
