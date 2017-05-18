package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Arguments_MiniJava {
LEX_MiniJava scanner;
  S_Arguments_MiniJava() {
	}
  S_Arguments_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Arguments att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  String att_nomClasse;
  private void regle83() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_3.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_83();
  }
  private void regle84() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expressions_MiniJava x_3 = new S_Expressions_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_84(x_3);
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_84(x_3);
  }
private void action_auto_inh_84(S_Expressions_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Arguments -> parenthese_ouvrante Expressions parenthese_fermante #ast ;", e });
}
  }
private void action_ast_83() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createArguments();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Arguments -> parenthese_ouvrante parenthese_fermante #ast ;", e });
}
  }
private void action_ast_84(S_Expressions_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createArguments(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Arguments -> parenthese_ouvrante Expressions parenthese_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_parenthese_fermante : // 58
            regle83 () ;
          break ;
          case LEX_MiniJava.token_accolade_ouvrante : // 53
            regle84 () ;
          break ;
          case LEX_MiniJava.token_soustraction : // 70
            regle84 () ;
          break ;
          case LEX_MiniJava.token_negation : // 76
            regle84 () ;
          break ;
          case LEX_MiniJava.token_entier : // 106
            regle84 () ;
          break ;
          case LEX_MiniJava.token_vrai : // 78
            regle84 () ;
          break ;
          case LEX_MiniJava.token_faux : // 79
            regle84 () ;
          break ;
          case LEX_MiniJava.token_chaine : // 104
            regle84 () ;
          break ;
          case LEX_MiniJava.token_caractere : // 105
            regle84 () ;
          break ;
          case LEX_MiniJava.token_nouveau : // 83
            regle84 () ;
          break ;
          case LEX_MiniJava.token_parenthese_ouvrante : // 57
            regle84 () ;
          break ;
          case LEX_MiniJava.token_identificateur_type : // 108
            regle84 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 107
            regle84 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_parenthese_ouvrante);
        }
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
