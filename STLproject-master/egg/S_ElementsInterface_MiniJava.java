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
public class S_ElementsInterface_MiniJava {
LEX_MiniJava scanner;
  S_ElementsInterface_MiniJava() {
	}
  S_ElementsInterface_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<ElementInterface> att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTableMethodes att_tdsMethodes;
  String att_identObjetCourant;
  private void regle9() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_9();
  }
  private void regle8() throws Exception {

	//declaration
	S_ElementInterface_MiniJava x_2 = new S_ElementInterface_MiniJava(scanner,att_eval) ;
	S_ElementsInterface_MiniJava x_4 = new S_ElementsInterface_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_8(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_tds_8(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_8(x_2, x_4);
  }
private void action_ast_9() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<ElementInterface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementsInterface -> #ast ;", e });
}
  }
private void action_auto_inh_8(S_ElementInterface_MiniJava x_2, S_ElementsInterface_MiniJava x_4) throws Exception {
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
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_2.att_identObjetCourant=this.att_identObjetCourant;
x_4.att_identObjetCourant=this.att_identObjetCourant;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","ElementsInterface -> ElementInterface #tds ElementsInterface1 #ast ;", e });
}
  }
private void action_ast_8(S_ElementInterface_MiniJava x_2, S_ElementsInterface_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","ElementsInterface -> ElementInterface #tds ElementsInterface1 #ast ;", e });
}
  }
private void action_tds_8(S_ElementInterface_MiniJava x_2, S_ElementsInterface_MiniJava x_4) throws Exception {
try {
// instructions
this.att_tds.register(x_2.att_ast);
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","ElementsInterface -> ElementInterface #tds ElementsInterface1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_final : // 102
        regle8 () ;
      break ;
      case LEX_MiniJava.token_vide : // 90
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 87
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle8 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle8 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle8 () ;
      break ;
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle9 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
