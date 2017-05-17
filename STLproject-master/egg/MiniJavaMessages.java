package egg;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class MiniJavaMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "MiniJava";
  private MiniJavaMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, egg.MiniJavaMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String Facteur_identificateur;
  public static  String CLASS_nom_constructeur_incorrect;
  public static  String MiniJava_unexpected_token;
  public static  String Interface_undefined_ident;
  public static  String variable_already_defined;
  public static  String Signature_ident_already_defined;
  public static  String MiniJava_expected_eof;
  public static  String Identificateur_Type_undefined;
  public static  String NOT_AN_ATTRIBUT;
  public static  String instruction_expression;
  public static  String PARAM_already_defined;
  public static  String Acces_idend_apOac;
  public static  String field_ident_already_defined;
  public static  String CLASS_attribut_already_defined;
  public static  String Programme_undeclared_variable;
  public static  String MiniJava_expected_token;
  public static  String already_defined_ident;
  public static  String expression_affectation;
  public static  String Class_already_defined;
  public static  String Class_Interface_ident_conflict;
  public static  String NOT_A_VARIABLE_DECLARATION;
  public static  String CLASS_undefined_ident;
  }
