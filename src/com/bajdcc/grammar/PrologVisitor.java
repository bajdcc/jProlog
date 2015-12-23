// Generated from O:/java_project/jProlog\Prolog.g4 by ANTLR 4.5.1
package com.bajdcc.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PrologParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PrologVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PrologParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(PrologParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(PrologParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(PrologParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#setDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDef(PrologParser.SetDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#setParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetParams(PrologParser.SetParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#setParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetParam(PrologParser.SetParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#variableDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDef(PrologParser.VariableDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#vDef1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVDef1(PrologParser.VDef1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#vDef2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVDef2(PrologParser.VDef2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#vDef3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVDef3(PrologParser.VDef3Context ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#typeParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParams(PrologParser.TypeParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#conditionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionDef(PrologParser.ConditionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#quantifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiers(PrologParser.QuantifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(PrologParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PrologParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrologParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PrologParser.ExpressionContext ctx);
}