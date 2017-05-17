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
public class S_AttributOuMethode_MiniJava {
LEX_MiniJava scanner;
  S_AttributOuMethode_MiniJava() {
	}
  S_AttributOuMethode_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  ElementClasse att_ast;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  boolean att_eval;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  DroitAcces att_droit;
  Integer att_typeElementClasse;
  String att_nomClasse;
  SymbolTable att_tdsMeth;
  private void regle32() throws Exception {

	//declaration
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_6 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_8 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_32(x_4, x_6, x_8);
if  (att_eval)	  action_factory_32(x_4, x_6, x_8);
	x_3.analyser(LEX_MiniJava.token_vide);
	x_4.analyser(LEX_MiniJava.token_identificateur);
	x_5.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_parenthese_fermante);
	x_8.analyser() ;
if  (att_eval)	  action_ast_32(x_4, x_6, x_8);
  }
  private void regle31() throws Exception {

	//declaration
	S_Type_MiniJava x_2 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_SuiteAttributOuMethode_MiniJava x_5 = new S_SuiteAttributOuMethode_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_31(x_2, x_3, x_5);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_inh_31(x_2, x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_31(x_2, x_3, x_5);
  }
private void action_inh_31(S_Type_MiniJava x_2, T_MiniJava x_3, S_SuiteAttributOuMethode_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_nomAtt=x_3.att_txt;
x_5.att_typeAtt=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","AttributOuMethode -> Type identificateur #inh SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_auto_inh_31(S_Type_MiniJava x_2, T_MiniJava x_3, S_SuiteAttributOuMethode_MiniJava x_5) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_5.att_tdsMeth=this.att_tdsMeth;
x_5.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_5.att_droit=this.att_droit;
x_5.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AttributOuMethode -> Type identificateur #inh SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_auto_inh_32(T_MiniJava x_4, S_Parametres_MiniJava x_6, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_6.att_tdsClasses=this.att_tdsClasses;
x_8.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsInterface=this.att_tdsInterface;
x_8.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_8.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_8.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tds=this.att_tds;
x_8.att_tds=this.att_tds;
x_8.att_tdsAtt=this.att_tdsAtt;
x_6.att_factory=this.att_factory;
x_8.att_factory=this.att_factory;
x_8.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","AttributOuMethode -> #factory vide identificateur parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_factory_32(T_MiniJava x_4, S_Parametres_MiniJava x_6, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_6.att_tds_Params= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#factory","AttributOuMethode -> #factory vide identificateur parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_ast_31(S_Type_MiniJava x_2, T_MiniJava x_3, S_SuiteAttributOuMethode_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
this.att_typeElementClasse=x_5.att_typeElementClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AttributOuMethode -> Type identificateur #inh SuiteAttributOuMethode #ast ;", e });
}
  }
private void action_ast_32(T_MiniJava x_4, S_Parametres_MiniJava x_6, S_Bloc_MiniJava x_8) throws Exception {
try {
// locales
ElementClasse loc_m;
// instructions
loc_m=this.att_factory.createMethode(this.att_droit, x_4.att_txt, x_6.att_ast, x_8.att_ast);
this.att_ast=loc_m;
this.att_typeElementClasse=1;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","AttributOuMethode -> #factory vide identificateur parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 87
        regle31 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle31 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle31 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle31 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle31 () ;
      break ;
      case LEX_MiniJava.token_vide : // 90
        regle32 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
