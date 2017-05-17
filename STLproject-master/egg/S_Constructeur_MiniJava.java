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
public class S_Constructeur_MiniJava {
LEX_MiniJava scanner;
  S_Constructeur_MiniJava() {
	}
  S_Constructeur_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ElementClasse att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle35() throws Exception {

	//declaration
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Parametres_MiniJava x_5 = new S_Parametres_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_7 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_35(x_3, x_5, x_7);
if  (att_eval)	  action_factory_35(x_3, x_5, x_7);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
	x_4.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_parenthese_fermante);
	x_7.analyser() ;
if  (att_eval)	  action_ast_35(x_3, x_5, x_7);
  }
private void action_auto_inh_35(T_MiniJava x_3, S_Parametres_MiniJava x_5, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
x_5.att_tdsClasses=this.att_tdsClasses;
x_7.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsInterface=this.att_tdsInterface;
x_7.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_7.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_7.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tds=this.att_tds;
x_7.att_tds=this.att_tds;
x_7.att_tdsAtt=this.att_tdsAtt;
x_5.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
x_7.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Constructeur -> #factory identificateur_type parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_factory_35(T_MiniJava x_3, S_Parametres_MiniJava x_5, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
x_5.att_tds_Params= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#factory","Constructeur -> #factory identificateur_type parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_ast_35(T_MiniJava x_3, S_Parametres_MiniJava x_5, S_Bloc_MiniJava x_7) throws Exception {
try {
// instructions
if (this.att_nomClasse.equals(x_3.att_txt)){
this.att_ast=this.att_factory.createConstructeur(x_3.att_txt, x_5.att_ast, x_7.att_ast);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_CLASS_nom_constructeur_incorrect, MiniJavaMessages.CLASS_nom_constructeur_incorrect,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Constructeur -> #factory identificateur_type parenthese_ouvrante Parametres parenthese_fermante Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle35 () ;
  }
  }
