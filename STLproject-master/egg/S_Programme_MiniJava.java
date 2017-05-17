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
public class S_Programme_MiniJava {
LEX_MiniJava scanner;
  S_Programme_MiniJava() {
	}
  S_Programme_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  Programme att_ast;
  LEX_MiniJava att_scanner;
  SymbolTable glob_0_s_meth;
  SymbolTable glob_0_s_clas;
  SymbolTable glob_0_s_att;
  SymbolTable glob_0_s_intr;
  private void regle0() throws Exception {

	//declaration
	S_Interfaces_MiniJava x_3 = new S_Interfaces_MiniJava(scanner,att_eval) ;
	S_Classes_MiniJava x_5 = new S_Classes_MiniJava(scanner,att_eval) ;
	S_Principale_MiniJava x_7 = new S_Principale_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_inter_0(x_3, x_5, x_7);
	x_3.analyser() ;
if  (att_eval)	  action_class_0(x_3, x_5, x_7);
	x_5.analyser() ;
if  (att_eval)	  action_principal_0(x_3, x_5, x_7);
	x_7.analyser() ;
if  (att_eval)	  action_ast_0(x_3, x_5, x_7);
  }
private void action_inter_0(S_Interfaces_MiniJava x_3, S_Classes_MiniJava x_5, S_Principale_MiniJava x_7) throws Exception {
try {
// instructions
glob_0_s_intr= new SymbolTable();
glob_0_s_clas= new SymbolTable();
glob_0_s_meth= new SymbolTable();
glob_0_s_att= new SymbolTable();
x_3.att_tdsInterface=glob_0_s_intr;
x_3.att_tdsClasses=glob_0_s_clas;
x_3.att_tdsMethodes=glob_0_s_meth;
x_3.att_tdsAttributs=glob_0_s_att;
x_3.att_tds= new SymbolTable();
x_3.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inter","Programme -> #inter Interfaces #class Classes #principal Principale #ast ;", e });
}
  }
private void action_class_0(S_Interfaces_MiniJava x_3, S_Classes_MiniJava x_5, S_Principale_MiniJava x_7) throws Exception {
try {
// instructions
x_5.att_tdsInterface=glob_0_s_intr;
x_5.att_tdsClasses=glob_0_s_clas;
x_5.att_tdsMethodes=glob_0_s_meth;
x_5.att_tdsAttributs=glob_0_s_att;
x_5.att_tds= new SymbolTable();
x_5.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#class","Programme -> #inter Interfaces #class Classes #principal Principale #ast ;", e });
}
  }
private void action_principal_0(S_Interfaces_MiniJava x_3, S_Classes_MiniJava x_5, S_Principale_MiniJava x_7) throws Exception {
try {
// instructions
x_7.att_tdsInterface=glob_0_s_intr;
x_7.att_tdsClasses=glob_0_s_clas;
x_7.att_tdsMethodes=glob_0_s_meth;
x_7.att_tdsAttributs=glob_0_s_att;
x_7.att_tds= new SymbolTable();
x_7.att_factory= new BlockFactoryImpl();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#principal","Programme -> #inter Interfaces #class Classes #principal Principale #ast ;", e });
}
  }
private void action_ast_0(S_Interfaces_MiniJava x_3, S_Classes_MiniJava x_5, S_Principale_MiniJava x_7) throws Exception {
try {
// instructions
this.att_ast= new ProgrammeImpl(x_3.att_ast, x_5.att_ast, x_7.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Programme -> #inter Interfaces #class Classes #principal Principale #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_interface : // 94
        regle0 () ;
      break ;
      case LEX_MiniJava.token_classe : // 95
        regle0 () ;
      break ;
      case LEX_MiniJava.token_public : // 98
        regle0 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
