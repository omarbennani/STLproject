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
public class S_Multiplicatif_MiniJava {
LEX_MiniJava scanner;
  S_Multiplicatif_MiniJava() {
	}
  S_Multiplicatif_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_MiniJava att_scanner;
  BinaryOperator att_bin_op;
  private void regle103() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_division);
if  (att_eval)	  action_ast_103();
  }
  private void regle102() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_multiplication);
if  (att_eval)	  action_ast_102();
  }
  private void regle105() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_et);
if  (att_eval)	  action_ast_105();
  }
  private void regle104() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_MiniJava.token_modulo);
if  (att_eval)	  action_ast_104();
  }
private void action_ast_104() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Modulo;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Multiplicatif -> modulo #ast ;", e });
}
  }
private void action_ast_105() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.And;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Multiplicatif -> et #ast ;", e });
}
  }
private void action_ast_102() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Multiply;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Multiplicatif -> multiplication #ast ;", e });
}
  }
private void action_ast_103() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Divide;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Multiplicatif -> division #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_multiplication : // 72
        regle102 () ;
      break ;
      case LEX_MiniJava.token_division : // 73
        regle103 () ;
      break ;
      case LEX_MiniJava.token_modulo : // 74
        regle104 () ;
      break ;
      case LEX_MiniJava.token_et : // 77
        regle105 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
