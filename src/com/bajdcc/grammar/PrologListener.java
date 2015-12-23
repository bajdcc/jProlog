// Generated from O:/java_project/jProlog\Prolog.g4 by ANTLR 4.5.1
package com.bajdcc.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrologParser}.
 */
public interface PrologListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrologParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(PrologParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(PrologParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(PrologParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(PrologParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PrologParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PrologParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#setDef}.
	 * @param ctx the parse tree
	 */
	void enterSetDef(PrologParser.SetDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#setDef}.
	 * @param ctx the parse tree
	 */
	void exitSetDef(PrologParser.SetDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#setParams}.
	 * @param ctx the parse tree
	 */
	void enterSetParams(PrologParser.SetParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#setParams}.
	 * @param ctx the parse tree
	 */
	void exitSetParams(PrologParser.SetParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#setParam}.
	 * @param ctx the parse tree
	 */
	void enterSetParam(PrologParser.SetParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#setParam}.
	 * @param ctx the parse tree
	 */
	void exitSetParam(PrologParser.SetParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void enterVariableDef(PrologParser.VariableDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#variableDef}.
	 * @param ctx the parse tree
	 */
	void exitVariableDef(PrologParser.VariableDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#vDef1}.
	 * @param ctx the parse tree
	 */
	void enterVDef1(PrologParser.VDef1Context ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#vDef1}.
	 * @param ctx the parse tree
	 */
	void exitVDef1(PrologParser.VDef1Context ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#vDef2}.
	 * @param ctx the parse tree
	 */
	void enterVDef2(PrologParser.VDef2Context ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#vDef2}.
	 * @param ctx the parse tree
	 */
	void exitVDef2(PrologParser.VDef2Context ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#vDef3}.
	 * @param ctx the parse tree
	 */
	void enterVDef3(PrologParser.VDef3Context ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#vDef3}.
	 * @param ctx the parse tree
	 */
	void exitVDef3(PrologParser.VDef3Context ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void enterTypeParams(PrologParser.TypeParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#typeParams}.
	 * @param ctx the parse tree
	 */
	void exitTypeParams(PrologParser.TypeParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#conditionDef}.
	 * @param ctx the parse tree
	 */
	void enterConditionDef(PrologParser.ConditionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#conditionDef}.
	 * @param ctx the parse tree
	 */
	void exitConditionDef(PrologParser.ConditionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#quantifiers}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiers(PrologParser.QuantifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#quantifiers}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiers(PrologParser.QuantifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(PrologParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(PrologParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PrologParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PrologParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrologParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PrologParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrologParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PrologParser.ExpressionContext ctx);
}