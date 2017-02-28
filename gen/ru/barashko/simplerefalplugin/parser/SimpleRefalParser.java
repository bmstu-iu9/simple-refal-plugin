// This is a generated file. Not intended for manual editing.
package ru.barashko.simplerefalplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ru.barashko.simplerefalplugin.psi.SimpleRefalTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleRefalParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == BLOCK) {
      r = block(b, 0);
    }
    else if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == COMMON_TERM) {
      r = commonTerm(b, 0);
    }
    else if (t == ENUM_DEFINITION) {
      r = enumDefinition(b, 0);
    }
    else if (t == EXTERNAL_DECLARATION) {
      r = externalDeclaration(b, 0);
    }
    else if (t == FORWARD_DECRATION) {
      r = forwardDecration(b, 0);
    }
    else if (t == FUNCTION_DEFINITION) {
      r = functionDefinition(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = identifier(b, 0);
    }
    else if (t == IDENTIFIER_DEFINITION) {
      r = identifierDefinition(b, 0);
    }
    else if (t == NAME_LIST) {
      r = nameList(b, 0);
    }
    else if (t == PATTERN) {
      r = pattern(b, 0);
    }
    else if (t == PATTERN_TERM) {
      r = patternTerm(b, 0);
    }
    else if (t == PROGRAM_ELEMENT) {
      r = programElement(b, 0);
    }
    else if (t == REDEFINITION_VARIABLE) {
      r = redefinitionVariable(b, 0);
    }
    else if (t == RESULT) {
      r = result(b, 0);
    }
    else if (t == RESULT_TERM) {
      r = resultTerm(b, 0);
    }
    else if (t == SENTENCE) {
      r = sentence(b, 0);
    }
    else if (t == SWAP_DEFINITION) {
      r = swapDefinition(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // LBRACE sentence* RBRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // sentence*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sentence(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // MULTILINE_COMMENT | END_OF_LINE_COMMENT | MULTILINE_COMMENT2
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, MULTILINE_COMMENT);
    if (!r) r = consumeToken(b, END_OF_LINE_COMMENT);
    if (!r) r = consumeToken(b, MULTILINE_COMMENT2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE | NAME | identifier | QUOTEDSTRING | INTEGER_LITERAL
  public static boolean commonTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commonTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMON_TERM, "<common term>");
    r = consumeToken(b, VARIABLE);
    if (!r) r = consumeToken(b, NAME);
    if (!r) r = identifier(b, l + 1);
    if (!r) r = consumeToken(b, QUOTEDSTRING);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ENUM | EENUM) nameList
  public static boolean enumDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDefinition")) return false;
    if (!nextTokenIs(b, "<enum definition>", EENUM, ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = enumDefinition_0(b, l + 1);
    r = r && nameList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ENUM | EENUM
  private static boolean enumDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, EENUM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXTERN nameList
  public static boolean externalDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externalDeclaration")) return false;
    if (!nextTokenIs(b, EXTERN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTERN);
    r = r && nameList(b, l + 1);
    exit_section_(b, m, EXTERNAL_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // FORWARD nameList
  public static boolean forwardDecration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forwardDecration")) return false;
    if (!nextTokenIs(b, FORWARD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORWARD);
    r = r && nameList(b, l + 1);
    exit_section_(b, m, FORWARD_DECRATION, r);
    return r;
  }

  /* ********************************************************** */
  // ENTRY? NAME block
  public static boolean functionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefinition")) return false;
    if (!nextTokenIs(b, "<function definition>", ENTRY, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINITION, "<function definition>");
    r = functionDefinition_0(b, l + 1);
    r = r && consumeToken(b, NAME);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ENTRY?
  private static boolean functionDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefinition_0")) return false;
    consumeToken(b, ENTRY);
    return true;
  }

  /* ********************************************************** */
  // SHARP NAME
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, SHARP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SHARP, NAME);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // LABEL nameList
  public static boolean identifierDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierDefinition")) return false;
    if (!nextTokenIs(b, LABEL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LABEL);
    r = r && nameList(b, l + 1);
    exit_section_(b, m, IDENTIFIER_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // NAME (COMMA NAME)* SEMICOLON
  public static boolean nameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameList")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    r = r && nameList_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, NAME_LIST, r);
    return r;
  }

  // (COMMA NAME)*
  private static boolean nameList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!nameList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nameList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA NAME
  private static boolean nameList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // patternTerm*
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    int c = current_position_(b);
    while (true) {
      if (!patternTerm(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // commonTerm | LPAREN pattern RPAREN | LBRACKET NAME pattern RPAREN | redefinitionVariable
  public static boolean patternTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_TERM, "<pattern term>");
    r = commonTerm(b, l + 1);
    if (!r) r = patternTerm_1(b, l + 1);
    if (!r) r = patternTerm_2(b, l + 1);
    if (!r) r = redefinitionVariable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN pattern RPAREN
  private static boolean patternTerm_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternTerm_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET NAME pattern RPAREN
  private static boolean patternTerm_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternTerm_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, NAME);
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // programElement*
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    int c = current_position_(b);
    while (true) {
      if (!programElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // externalDeclaration
  //                 | enumDefinition
  //                 | swapDefinition
  //                 | functionDefinition
  //                 | forwardDecration
  //                 | identifierDefinition
  //                 | SEMICOLON
  public static boolean programElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "programElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROGRAM_ELEMENT, "<program element>");
    r = externalDeclaration(b, l + 1);
    if (!r) r = enumDefinition(b, l + 1);
    if (!r) r = swapDefinition(b, l + 1);
    if (!r) r = functionDefinition(b, l + 1);
    if (!r) r = forwardDecration(b, l + 1);
    if (!r) r = identifierDefinition(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE CARET
  public static boolean redefinitionVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "redefinitionVariable")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VARIABLE, CARET);
    exit_section_(b, m, REDEFINITION_VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // resultTerm*
  public static boolean result(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "result")) return false;
    Marker m = enter_section_(b, l, _NONE_, RESULT, "<result>");
    int c = current_position_(b);
    while (true) {
      if (!resultTerm(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "result", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // NAME DOUBLECOLON NAME | commonTerm |  LPAREN result RPAREN | LBRACKET NAME result RBRACKET | LCHEVRON result RCHEVRON | block
  public static boolean resultTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resultTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESULT_TERM, "<result term>");
    r = parseTokens(b, 0, NAME, DOUBLECOLON, NAME);
    if (!r) r = commonTerm(b, l + 1);
    if (!r) r = resultTerm_2(b, l + 1);
    if (!r) r = resultTerm_3(b, l + 1);
    if (!r) r = resultTerm_4(b, l + 1);
    if (!r) r = block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN result RPAREN
  private static boolean resultTerm_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resultTerm_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && result(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET NAME result RBRACKET
  private static boolean resultTerm_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resultTerm_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, NAME);
    r = r && result(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // LCHEVRON result RCHEVRON
  private static boolean resultTerm_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resultTerm_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCHEVRON);
    r = r && result(b, l + 1);
    r = r && consumeToken(b, RCHEVRON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pattern EQUAL result SEMICOLON
  public static boolean sentence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SENTENCE, "<sentence>");
    r = pattern(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && result(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (SWAP | ESWAP) nameList
  public static boolean swapDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "swapDefinition")) return false;
    if (!nextTokenIs(b, "<swap definition>", ESWAP, SWAP)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWAP_DEFINITION, "<swap definition>");
    r = swapDefinition_0(b, l + 1);
    r = r && nameList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SWAP | ESWAP
  private static boolean swapDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "swapDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWAP);
    if (!r) r = consumeToken(b, ESWAP);
    exit_section_(b, m, null, r);
    return r;
  }

}