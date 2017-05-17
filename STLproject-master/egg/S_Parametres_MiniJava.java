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
public class S_Parametres_MiniJava {
LEX_MiniJava scanner;
  S_Parametres_MiniJava() {
	}
  S_Parametres_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Parametre> att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tds_Params;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  private void regle37() throws Exception {

	//declaration
	S_Parametre_MiniJava x_2 = new S_Parametre_MiniJava(scanner,att_eval) ;
	S_SuiteParametres_MiniJava x_4 = new S_SuiteParametres_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_37(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_tds_37(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_37(x_2, x_4);
  }
  private void regle36() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_36();
  }
private void action_ast_36() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Parametre>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Parametres -> #ast ;", e });
}
  }
private void action_ast_37(S_Parametre_MiniJava x_2, S_SuiteParametres_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Parametres -> Parametre #tds SuiteParametres #ast ;", e });
}
  }
private void action_auto_inh_37(S_Parametre_MiniJava x_2, S_SuiteParametres_MiniJava x_4) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_2.att_tds_Params=this.att_tds_Params;
x_4.att_tds_Params=this.att_tds_Params;
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Parametres -> Parametre #tds SuiteParametres #ast ;", e });
}
  }
private void action_tds_37(S_Parametre_MiniJava x_2, S_SuiteParametres_MiniJava x_4) throws Exception {
try {
// instructions
this.att_tds_Params.register(x_2.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Parametres -> Parametre #tds SuiteParametres #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_parenthese_fermante : // 58
        regle36 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 87
        regle37 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle37 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle37 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle37 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle37 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
