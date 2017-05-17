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
public class S_Expression_MiniJava {
LEX_MiniJava scanner;
  S_Expression_MiniJava() {
	}
  S_Expression_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle63() throws Exception {

	//declaration
	S_Affectation_MiniJava x_2 = new S_Affectation_MiniJava(scanner,att_eval) ;
	S_SuiteAffectation_MiniJava x_4 = new S_SuiteAffectation_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_63(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_gauche_63(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_63(x_2, x_4);
  }
private void action_auto_inh_63(S_Affectation_MiniJava x_2, S_SuiteAffectation_MiniJava x_4) throws Exception {
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
x_2.att_tdsAtt=this.att_tdsAtt;
x_4.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_2.att_nomClasse=this.att_nomClasse;
x_4.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Expression -> Affectation #gauche SuiteAffectation #ast ;", e });
}
  }
private void action_ast_63(S_Affectation_MiniJava x_2, S_SuiteAffectation_MiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Expression -> Affectation #gauche SuiteAffectation #ast ;", e });
}
  }
private void action_gauche_63(S_Affectation_MiniJava x_2, S_SuiteAffectation_MiniJava x_4) throws Exception {
try {
// instructions
if ((x_2.att_ast==null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_expression_affectation, MiniJavaMessages.expression_affectation,new Object[]{""+"affectation ast should be not null"});

}
else {
x_4.att_gauche=x_2.att_ast;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#gauche","Expression -> Affectation #gauche SuiteAffectation #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle63 () ;
  }
  }
