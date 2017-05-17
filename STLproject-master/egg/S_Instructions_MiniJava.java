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
public class S_Instructions_MiniJava {
LEX_MiniJava scanner;
  S_Instructions_MiniJava() {
	}
  S_Instructions_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  SymbolTable att_tdsAtt;
  List<Instruction> att_insts;
  LEX_MiniJava att_scanner;
  List<Instruction> att_tree;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle50() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_50();
  }
  private void regle51() throws Exception {

	//declaration
	S_Instruction_MiniJava x_2 = new S_Instruction_MiniJava(scanner,att_eval) ;
	S_Instructions_MiniJava x_4 = new S_Instructions_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_51(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_tree_51(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_51(x_2, x_4);
  }
private void action_auto_inh_51(S_Instruction_MiniJava x_2, S_Instructions_MiniJava x_4) throws Exception {
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
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instructions -> Instruction #tree Instructions1 #ast ;", e });
}
  }
private void action_tree_51(S_Instruction_MiniJava x_2, S_Instructions_MiniJava x_4) throws Exception {
try {
// instructions
this.att_tree.add(x_2.att_ast);
x_4.att_tree=this.att_tree;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tree","Instructions -> Instruction #tree Instructions1 #ast ;", e });
}
  }
private void action_ast_50() throws Exception {
try {
// instructions
this.att_insts=this.att_tree;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instructions -> #ast ;", e });
}
  }
private void action_ast_51(S_Instruction_MiniJava x_2, S_Instructions_MiniJava x_4) throws Exception {
try {
// instructions
this.att_insts=x_4.att_insts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instructions -> Instruction #tree Instructions1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_accolade_fermante : // 54
        regle50 () ;
      break ;
      case LEX_MiniJava.token_type_bool : // 87
        regle51 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle51 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle51 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle51 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle51 () ;
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 53
        regle51 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle51 () ;
      break ;
      case LEX_MiniJava.token_negation : // 76
        regle51 () ;
      break ;
      case LEX_MiniJava.token_entier : // 106
        regle51 () ;
      break ;
      case LEX_MiniJava.token_vrai : // 78
        regle51 () ;
      break ;
      case LEX_MiniJava.token_faux : // 79
        regle51 () ;
      break ;
      case LEX_MiniJava.token_chaine : // 104
        regle51 () ;
      break ;
      case LEX_MiniJava.token_caractere : // 105
        regle51 () ;
      break ;
      case LEX_MiniJava.token_nouveau : // 83
        regle51 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle51 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 107
        regle51 () ;
      break ;
      case LEX_MiniJava.token_si : // 80
        regle51 () ;
      break ;
      case LEX_MiniJava.token_tant_que : // 84
        regle51 () ;
      break ;
      case LEX_MiniJava.token_afficher : // 82
        regle51 () ;
      break ;
      case LEX_MiniJava.token_retour : // 85
        regle51 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
