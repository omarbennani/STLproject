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
public class S_ImplantationInterface_MiniJava {
LEX_MiniJava scanner;
  S_ImplantationInterface_MiniJava() {
	}
  S_ImplantationInterface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Interface> att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  private void regle19() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_SuiteHeritageInterface_MiniJava x_5 = new S_SuiteHeritageInterface_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_19(x_3, x_5);
	x_2.analyser(LEX_MiniJava.token_implantation);
	x_3.analyser(LEX_MiniJava.token_identificateur_type);
if  (att_eval)	  action_tds_19(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_19(x_3, x_5);
  }
  private void regle20() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_20();
  }
private void action_ast_19(T_MiniJava x_3, S_SuiteHeritageInterface_MiniJava x_5) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
// instructions
loc_f=this.att_tdsInterface.get(x_3.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof Interface ){
x_5.att_ast.addFirst(((Interface)loc_d));
}

this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ImplantationInterface -> implantation identificateur_type #tds SuiteHeritageInterface #ast ;", e });
}
  }
private void action_ast_20() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Interface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ImplantationInterface -> #ast ;", e });
}
  }
private void action_auto_inh_19(T_MiniJava x_3, S_SuiteHeritageInterface_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tds=this.att_tds;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ImplantationInterface -> implantation identificateur_type #tds SuiteHeritageInterface #ast ;", e });
}
  }
private void action_tds_19(T_MiniJava x_3, S_SuiteHeritageInterface_MiniJava x_5) throws Exception {
try {
// locales
List<String> loc_l;
// instructions
if ((this.att_tdsInterface.contains(x_3.att_txt))){
loc_l= new LinkedList<String>();
loc_l.add(x_3.att_txt);
x_5.att_listHeritage=loc_l;
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Interface_undefined_ident, MiniJavaMessages.Interface_undefined_ident,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ImplantationInterface -> implantation identificateur_type #tds SuiteHeritageInterface #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_implantation : // 97
        regle19 () ;
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 53
        regle20 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }