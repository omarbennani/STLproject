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
public class S_Signature_MiniJava {
LEX_MiniJava scanner;
  S_Signature_MiniJava() {
	}
  S_Signature_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Signature att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  String att_identObjetCourant;
  private void regle13() throws Exception {

	//declaration
	S_Type_MiniJava x_2 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_6 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_13(x_2, x_3, x_6);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_identificateur);
	x_4.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_Params_13(x_2, x_3, x_6);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_13(x_2, x_3, x_6);
  }
  private void regle12() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_6 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_12(x_3, x_6);
	x_2.analyser(LEX_MiniJava.token_vide);
	x_3.analyser(LEX_MiniJava.token_identificateur);
	x_4.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_Params_12(x_3, x_6);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_12(x_3, x_6);
  }
private void action_auto_inh_12(T_MiniJava x_3, S_Parametres_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tds=this.att_tds;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Signature -> vide identificateur parenthese_ouvrante #tds_Params Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_auto_inh_13(S_Type_MiniJava x_2, T_MiniJava x_3, S_Parametres_MiniJava x_6) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Signature -> Type identificateur parenthese_ouvrante #tds_Params Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_tds_Params_13(S_Type_MiniJava x_2, T_MiniJava x_3, S_Parametres_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds_Params= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds_Params","Signature -> Type identificateur parenthese_ouvrante #tds_Params Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_tds_Params_12(T_MiniJava x_3, S_Parametres_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds_Params= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds_Params","Signature -> vide identificateur parenthese_ouvrante #tds_Params Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_ast_12(T_MiniJava x_3, S_Parametres_MiniJava x_6) throws Exception {
try {
// instructions
if ((this.att_tds.knows(x_3.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Signature_ident_already_defined, MiniJavaMessages.Signature_ident_already_defined,new Object[]{""+x_3.att_txt});

}
else {
this.att_ast=this.att_factory.createSignature(x_3.att_txt, x_6.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Signature -> vide identificateur parenthese_ouvrante #tds_Params Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_ast_13(S_Type_MiniJava x_2, T_MiniJava x_3, S_Parametres_MiniJava x_6) throws Exception {
try {
// instructions
if ((this.att_tds.knows(x_3.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Signature_ident_already_defined, MiniJavaMessages.Signature_ident_already_defined,new Object[]{""+x_3.att_txt});

}
else {
this.att_ast=this.att_factory.createSignature(x_2.att_ast, x_3.att_txt, x_6.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Signature -> Type identificateur parenthese_ouvrante #tds_Params Parametres parenthese_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_vide : // 90
        regle12 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 87
        regle13 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle13 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle13 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle13 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle13 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
