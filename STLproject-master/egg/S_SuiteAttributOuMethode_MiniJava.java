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
public class S_SuiteAttributOuMethode_MiniJava {
LEX_MiniJava scanner;
  S_SuiteAttributOuMethode_MiniJava() {
	}
  S_SuiteAttributOuMethode_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  Type att_typeAtt;
  SymbolTable att_tds;
  ElementClasse att_ast;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  boolean att_eval;
  SymbolTable att_tdsAtt;
  String att_nomAtt;
  LEX_MiniJava att_scanner;
  DroitAcces att_droit;
  Integer att_typeElementClasse;
  String att_nomClasse;
  SymbolTable att_tdsMeth;
  private void regle34() throws Exception {

	//declaration
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_4 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_6 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_34(x_4, x_6);
if  (att_eval)	  action_factory_34(x_4, x_6);
	x_3.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_parenthese_fermante);
	x_6.analyser() ;
if  (att_eval)	  action_ast_34(x_4, x_6);
  }
  private void regle33() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_33();
  }
private void action_auto_inh_34(S_Parametres_MiniJava x_4, S_Bloc_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
x_6.att_tdsAtt=this.att_tdsAtt;
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_6.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","SuiteAttributOuMethode -> #factory parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_factory_34(S_Parametres_MiniJava x_4, S_Bloc_MiniJava x_6) throws Exception {
try {
// instructions
x_4.att_tds_Params= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#factory","SuiteAttributOuMethode -> #factory parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_ast_33() throws Exception {
try {
// locales
ElementClasse loc_a;
// instructions
if (this.att_tdsAtt.contains(this.att_nomAtt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_CLASS_attribut_already_defined, MiniJavaMessages.CLASS_attribut_already_defined,new Object[]{""+this.att_nomAtt});

}
else {
loc_a=this.att_factory.createAttribut(this.att_droit, this.att_typeAtt, this.att_nomAtt);
this.att_ast=loc_a;
this.att_tdsAtt.register(loc_a);
this.att_typeElementClasse=0;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteAttributOuMethode -> point_virgule #ast ;", e });
}
  }
private void action_ast_34(S_Parametres_MiniJava x_4, S_Bloc_MiniJava x_6) throws Exception {
try {
// locales
ElementClasse loc_m;
// instructions
loc_m=this.att_factory.createMethode(this.att_droit, this.att_typeAtt, this.att_nomAtt, x_4.att_ast, x_6.att_ast);
this.att_ast=loc_m;
this.att_typeElementClasse=1;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","SuiteAttributOuMethode -> #factory parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_point_virgule : // 64
        regle33 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle34 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
