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
public class S_Instruction_MiniJava {
LEX_MiniJava scanner;
  S_Instruction_MiniJava() {
	}
  S_Instruction_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Instruction att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle54() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_4 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_5 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_7 = new S_Bloc_MiniJava(scanner,att_eval) ;
	S_SuiteConditionnelle_MiniJava x_9 = new S_SuiteConditionnelle_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_54(x_4, x_7, x_9);
	x_2.analyser(LEX_MiniJava.token_si);
	x_3.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_tds2_54(x_4, x_7, x_9);
	x_7.analyser() ;
if  (att_eval)	  action_tds3_54(x_4, x_7, x_9);
	x_9.analyser() ;
if  (att_eval)	  action_ast_54(x_4, x_7, x_9);
  }
  private void regle53() throws Exception {

	//declaration
	S_Expression_MiniJava x_2 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_53(x_2);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_53(x_2);
  }
  private void regle52() throws Exception {

	//declaration
	S_Type_MiniJava x_2 = new S_Type_MiniJava(scanner,att_eval) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_6 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_7 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_52(x_2, x_3, x_6);
	x_2.analyser() ;
	x_3.analyser(LEX_MiniJava.token_identificateur);
	x_4.analyser(LEX_MiniJava.token_affectation);
if  (att_eval)	  action_tds_52(x_2, x_3, x_6);
	x_6.analyser() ;
	x_7.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_52(x_2, x_3, x_6);
if  (att_eval)	  action_tds1_52(x_2, x_3, x_6);
  }
  private void regle59() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_59(x_3);
	x_2.analyser(LEX_MiniJava.token_retour);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_59(x_3);
  }
  private void regle58() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_58(x_3);
	x_2.analyser(LEX_MiniJava.token_afficher);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_point_virgule);
if  (att_eval)	  action_ast_58(x_3);
  }
  private void regle57() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_5 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_6 = new T_MiniJava(scanner ) ;
	S_Bloc_MiniJava x_8 = new S_Bloc_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_57(x_5, x_8);
	x_2.analyser(LEX_MiniJava.token_tant_que);
	x_3.analyser(LEX_MiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds1_57(x_5, x_8);
	x_5.analyser() ;
	x_6.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_tds2_57(x_5, x_8);
	x_8.analyser() ;
if  (att_eval)	  action_ast_57(x_5, x_8);
  }
private void action_auto_inh_59(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> retour Expression point_virgule #ast ;", e });
}
  }
private void action_ast_52(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createVariableDeclaration(x_3.att_txt, x_2.att_ast, x_6.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instruction -> Type identificateur affectation #tds Expression point_virgule #ast #tds1 ;", e });
}
  }
private void action_tds3_54(S_Expression_MiniJava x_4, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_9) throws Exception {
try {
// instructions
x_9.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds3","Instruction -> si parenthese_ouvrante Expression parenthese_fermante #tds2 Bloc #tds3 SuiteConditionnelle #ast ;", e });
}
  }
private void action_ast_53(S_Expression_MiniJava x_2) throws Exception {
try {
// instructions
if ((x_2.att_ast==null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_instruction_expression, MiniJavaMessages.instruction_expression,new Object[]{""+"expression ast null"});

}
else {
if (x_2.att_ast instanceof Instruction ){
this.att_ast=((Instruction)x_2.att_ast);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_instruction_expression, MiniJavaMessages.instruction_expression,new Object[]{""+"dfqsjhvjhqs"});


}
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instruction -> Expression point_virgule #ast ;", e });
}
  }
private void action_tds2_54(S_Expression_MiniJava x_4, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_9) throws Exception {
try {
// instructions
x_7.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds2","Instruction -> si parenthese_ouvrante Expression parenthese_fermante #tds2 Bloc #tds3 SuiteConditionnelle #ast ;", e });
}
  }
private void action_ast_54(S_Expression_MiniJava x_4, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_9) throws Exception {
try {
// instructions
if (((x_9.att_ast==null))){
this.att_ast=this.att_factory.createConditional(x_4.att_ast, x_7.att_ast);
}
else {
this.att_ast=this.att_factory.createConditional(x_4.att_ast, x_7.att_ast, x_9.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instruction -> si parenthese_ouvrante Expression parenthese_fermante #tds2 Bloc #tds3 SuiteConditionnelle #ast ;", e });
}
  }
private void action_tds1_52(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// locales
Declaration loc_d;
// instructions
if (this.att_tds.knows(x_3.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_variable_already_defined, MiniJavaMessages.variable_already_defined,new Object[]{""+x_3.att_txt});

}
else {
loc_d=this.att_factory.createVariableDeclaration(x_3.att_txt, x_2.att_ast, x_6.att_ast);
this.att_tds.register(loc_d);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds1","Instruction -> Type identificateur affectation #tds Expression point_virgule #ast #tds1 ;", e });
}
  }
private void action_ast_57(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createRepetition(x_5.att_ast, x_8.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instruction -> tant_que parenthese_ouvrante #tds1 Expression parenthese_fermante #tds2 Bloc #ast ;", e });
}
  }
private void action_tds_52(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds","Instruction -> Type identificateur affectation #tds Expression point_virgule #ast #tds1 ;", e });
}
  }
private void action_tds1_57(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds1","Instruction -> tant_que parenthese_ouvrante #tds1 Expression parenthese_fermante #tds2 Bloc #ast ;", e });
}
  }
private void action_ast_58(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createPrinter(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instruction -> afficher Expression point_virgule #ast ;", e });
}
  }
private void action_auto_inh_52(S_Type_MiniJava x_2, T_MiniJava x_3, S_Expression_MiniJava x_6) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_6.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_6.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> Type identificateur affectation #tds Expression point_virgule #ast #tds1 ;", e });
}
  }
private void action_ast_59(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createReturnInstruction(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Instruction -> retour Expression point_virgule #ast ;", e });
}
  }
private void action_auto_inh_53(S_Expression_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_tdsAtt=this.att_tdsAtt;
x_2.att_factory=this.att_factory;
x_2.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> Expression point_virgule #ast ;", e });
}
  }
private void action_auto_inh_54(S_Expression_MiniJava x_4, S_Bloc_MiniJava x_7, S_SuiteConditionnelle_MiniJava x_9) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_7.att_tdsClasses=this.att_tdsClasses;
x_9.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_7.att_tdsInterface=this.att_tdsInterface;
x_9.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_7.att_tdsMethodes=this.att_tdsMethodes;
x_9.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_7.att_tdsAttributs=this.att_tdsAttributs;
x_9.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_4.att_tdsAtt=this.att_tdsAtt;
x_7.att_tdsAtt=this.att_tdsAtt;
x_9.att_tdsAtt=this.att_tdsAtt;
x_4.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
x_9.att_factory=this.att_factory;
x_4.att_nomClasse=this.att_nomClasse;
x_7.att_nomClasse=this.att_nomClasse;
x_9.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> si parenthese_ouvrante Expression parenthese_fermante #tds2 Bloc #tds3 SuiteConditionnelle #ast ;", e });
}
  }
private void action_auto_inh_57(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_5.att_tdsClasses=this.att_tdsClasses;
x_8.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsInterface=this.att_tdsInterface;
x_8.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_8.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_8.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAtt=this.att_tdsAtt;
x_8.att_tdsAtt=this.att_tdsAtt;
x_5.att_factory=this.att_factory;
x_8.att_factory=this.att_factory;
x_5.att_nomClasse=this.att_nomClasse;
x_8.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> tant_que parenthese_ouvrante #tds1 Expression parenthese_fermante #tds2 Bloc #ast ;", e });
}
  }
private void action_tds2_57(S_Expression_MiniJava x_5, S_Bloc_MiniJava x_8) throws Exception {
try {
// instructions
x_8.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#tds2","Instruction -> tant_que parenthese_ouvrante #tds1 Expression parenthese_fermante #tds2 Bloc #ast ;", e });
}
  }
private void action_auto_inh_58(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Instruction -> afficher Expression point_virgule #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_type_bool : // 87
        regle52 () ;
      break ;
      case LEX_MiniJava.token_type_int : // 86
        regle52 () ;
      break ;
      case LEX_MiniJava.token_type_char : // 88
        regle52 () ;
      break ;
      case LEX_MiniJava.token_type_String : // 89
        regle52 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_MiniJava.token_crochet_ouvrant : // 55
            regle52 () ;
          break ;
          case LEX_MiniJava.token_identificateur : // 107
            regle52 () ;
          break ;
          case LEX_MiniJava.token_point : // 63
            regle53 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_MiniJava.token_identificateur_type);
        }
      break ;
      case LEX_MiniJava.token_accolade_ouvrante : // 53
        regle53 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle53 () ;
      break ;
      case LEX_MiniJava.token_negation : // 76
        regle53 () ;
      break ;
      case LEX_MiniJava.token_entier : // 106
        regle53 () ;
      break ;
      case LEX_MiniJava.token_vrai : // 78
        regle53 () ;
      break ;
      case LEX_MiniJava.token_faux : // 79
        regle53 () ;
      break ;
      case LEX_MiniJava.token_chaine : // 104
        regle53 () ;
      break ;
      case LEX_MiniJava.token_caractere : // 105
        regle53 () ;
      break ;
      case LEX_MiniJava.token_nouveau : // 83
        regle53 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle53 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 107
        regle53 () ;
      break ;
      case LEX_MiniJava.token_si : // 80
        regle54 () ;
      break ;
      case LEX_MiniJava.token_tant_que : // 84
        regle57 () ;
      break ;
      case LEX_MiniJava.token_afficher : // 82
        regle58 () ;
      break ;
      case LEX_MiniJava.token_retour : // 85
        regle59 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
