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
public class S_Parametre_MiniJava {
LEX_MiniJava scanner;
  S_Parametre_MiniJava() {
	}
  S_Parametre_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Parametre att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tds_Params;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  private void regle40() throws Exception {

	//declaration
	S_Type_MiniJava x_2 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_40(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_ast_40(x_2, x_3);
  }
private void action_auto_inh_40(S_Type_MiniJava x_2, T_MiniJava x_3) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Parametre -> Type identificateur #ast ;", e });
}
  }
private void action_ast_40(S_Type_MiniJava x_2, T_MiniJava x_3) throws Exception {
try {
// instructions
if (this.att_tds_Params.contains(x_3.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_PARAM_already_defined, MiniJavaMessages.PARAM_already_defined,new Object[]{""+x_3.att_txt});

}
else {
this.att_ast=this.att_factory.createParametre(x_2.att_ast, x_3.att_txt);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Parametre -> Type identificateur #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle40 () ;
  }
  }
