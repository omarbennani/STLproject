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
public class S_Classe_MiniJava {
LEX_MiniJava scanner;
  S_Classe_MiniJava() {
	}
  S_Classe_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Classe att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  SymbolTable att_tdsMeth;
  private void regle16() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_HeritageClasse_MiniJava x_4 = new S_HeritageClasse_MiniJava(scanner,att_eval) ;
	S_ImplantationInterface_MiniJava x_5 = new S_ImplantationInterface_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_ElementsClasse_MiniJava x_8 = new S_ElementsClasse_MiniJava(scanner,att_eval) ;
	T_MiniJava x_9 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_16(x_3, x_4, x_5, x_8);
	x_2.analyser(LEX_MiniJava.token_classe);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_accolade_ouvrante);
if  (att_eval)	  action_inh_16(x_3, x_4, x_5, x_8);
	x_8.analyser() ;
	x_9.analyser(LEX_MiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_16(x_3, x_4, x_5, x_8);
  }
private void action_ast_16(T_MiniJava x_3, S_HeritageClasse_MiniJava x_4, S_ImplantationInterface_MiniJava x_5, S_ElementsClasse_MiniJava x_8) throws Exception {
try {
// instructions
if (this.att_tdsClasses.contains(x_3.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Class_already_defined, MiniJavaMessages.Class_already_defined,new Object[]{""+x_3.att_txt});

}
else if (this.att_tdsInterface.contains(x_3.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Class_Interface_ident_conflict, MiniJavaMessages.Class_Interface_ident_conflict,new Object[]{""+x_3.att_txt});

}
else {
this.att_ast=this.att_factory.createClasse(x_3.att_txt, x_4.att_ast, x_5.att_ast, x_8.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Classe -> classe identificateur_type HeritageClasse ImplantationInterface accolade_ouvrante #inh ElementsClasse accolade_fermante #ast ;", e });
}
  }
private void action_auto_inh_16(T_MiniJava x_3, S_HeritageClasse_MiniJava x_4, S_ImplantationInterface_MiniJava x_5, S_ElementsClasse_MiniJava x_8) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsClasses=this.att_tdsClasses;
x_8.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsInterface=this.att_tdsInterface;
x_8.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_8.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_8.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_8.att_tds=this.att_tds;
x_8.att_tdsMeth=this.att_tdsMeth;
x_8.att_tdsAtt=this.att_tdsAtt;
x_4.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_8.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Classe -> classe identificateur_type HeritageClasse ImplantationInterface accolade_ouvrante #inh ElementsClasse accolade_fermante #ast ;", e });
}
  }
private void action_inh_16(T_MiniJava x_3, S_HeritageClasse_MiniJava x_4, S_ImplantationInterface_MiniJava x_5, S_ElementsClasse_MiniJava x_8) throws Exception {
try {
// instructions
x_8.att_nomClasse=x_3.att_txt;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Classe -> classe identificateur_type HeritageClasse ImplantationInterface accolade_ouvrante #inh ElementsClasse accolade_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle16 () ;
  }
  }
