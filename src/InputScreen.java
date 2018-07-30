import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


// posibila optimizare urmatoare - inlocuirea componentelor grafice cu Arrays pentru mai multe ferestre de input si optimizare metode.
public class InputScreen extends JFrame
{	
	//default constants
	final int FLOWLAYOUT_VGAP = 1;
	final String GENERAL_STATIC_PATH = "";
	final String FISK_DINAMIC_PATH = "Template/Fisk.doc";
	final String FISK_STATIC_PATH = GENERAL_STATIC_PATH + FISK_DINAMIC_PATH;
	final String FISA_DINAMIC_PATH = "Template/Fisa.xls";
	final String FISA_STATIC_PATH = GENERAL_STATIC_PATH + FISA_DINAMIC_PATH;
	final String ALPHA_DINAMIC_PATH = "Template/Alpha.doc";
	final String ALPHA_STATIC_PATH = GENERAL_STATIC_PATH + ALPHA_DINAMIC_PATH;
	final String BCR_DINAMIC_PATH = "Template/Bcr.doc";
	final String BCR_STATIC_PATH = GENERAL_STATIC_PATH + BCR_DINAMIC_PATH;
	final String BCR_COMMON_DINAMIC_PATH = "Template/BcrCommon.doc";
	final String BCR_COMMON_STATIC_PATH = GENERAL_STATIC_PATH + BCR_DINAMIC_PATH;
	final String CETELEM_DINAMIC_PATH = "Template/BNPParibas.doc";
	final String CETELEM_STATIC_PATH = GENERAL_STATIC_PATH + CETELEM_DINAMIC_PATH;
	final String GARANTI_DINAMIC_PATH = "Template/Garanti.doc";
	final String GARANTI_STATIC_PATH = GENERAL_STATIC_PATH + GARANTI_DINAMIC_PATH;
	final String IDEA_DINAMIC_PATH = "Template/Idea.doc";
	final String IDEA_STATIC_PATH = GENERAL_STATIC_PATH + IDEA_DINAMIC_PATH;
	final String OTP_DINAMIC_PATH = "Template/OTP.doc";
	final String OTP_STATIC_PATH = GENERAL_STATIC_PATH + OTP_DINAMIC_PATH;
	final String OTP_CERERE_DINAMIC_PATH = "Template/OTPCerere.doc";
	final String OTP_COMMON_DINAMIC_PATH = "Template/OTPCommon.doc";
	final String PIRAEUS_DINAMIC_PATH = "Template/Piraeus.doc";
	final String PIRAEUS_STATIC_PATH = GENERAL_STATIC_PATH + PIRAEUS_DINAMIC_PATH;
	final String UNICREDIT_DINAMIC_PATH = "Template/Unicredit.doc";
	final String UNICREDIT_STATIC_PATH = GENERAL_STATIC_PATH + UNICREDIT_DINAMIC_PATH;
	final String UNICREDIT_COMMON_DINAMIC_PATH = "Template/UnicreditCommon.doc";
	final String UNICREDIT_COMMON_STATIC_PATH = GENERAL_STATIC_PATH + UNICREDIT_COMMON_DINAMIC_PATH;
	
	// default demographics 
	final static int NUME = 0;
	final static int PRENUME = 1;
	final static int CNP = 2;
	final static int EMAIL = 3;
	final static int ID = 4;
	final static int SERIE = 5;
	final static int NR_ID = 6;
	final static int LA_DATA = 7;
	final static int ELIBERAT_DE = 8;
	final static int ADRESA = 9;
	final static int DATA_NASTERE = 10;
	final static int LOCALITATE_NASTERE = 11;
	final static int RESEDINTA = 12;
	final static int SITUATIE_LOCATIVA = 13;
	final static int VECHIME_ADRESA = 14;
	final static int FUNCTIE = 15;
	final static int ANGAJATOR = 16;
	final static int VECHIME_TOTALA = 17;
	final static int SITUATIE_FAMILIALA = 18;
	final static int NUMAR_MEMBRI_FAMILIE = 19;
	final static int TELEFON_ANGAJATOR = 20;
	final static int TELEFON_FIX = 21;
	final static int TELEFON_MOBIL = 22;
	final static int NUME_MAMA = 23;
	final static int PRENUME_TATA = 24;
	final static int CNP_SOT = 25;
	final static int VALABIL_PANA_DATA = 26;
	final static int NUME_SOT = 27;
	final static int MASINA = 28;
	final static int STUDII = 29;
	final static int TIP_IMOBIL = 30;
	final static int TIP_VENIT = 31;
	final static int CUI = 32;
	final static int NR_ANGAJATI = 33;
	final static int DATA_INFIINTARE = 34;
	final static int ADRESA_ANGAJATOR = 35;
	final static int DATA_ANGAJARE = 36;
	final static int DOMENIU = 37;
	final static int CAPITAL = 38;
	final static int CAEN = 39;
	final static int MULTINATIONALA = 40;
	final static int TIP_SOCIETATE = 41;
	final static int PROFESIE = 42;
	final static int TIP_FUNCTIE = 43;
	final static int VECHIME_ULTIM_ANGAJATOR = 44;
	final static int BONURI_MASA = 45;
	final static int VENIT_3LUNI = 46;
	final static int VENIT_6LUNI = 47;
	final static int VENIT_12LUNI = 48;
	final static int TIP_VENIT_3LUNI = 49;
	final static int TIP_VENIT_6LUNI = 50;
	final static int TIP_VENIT_12LUNI = 51;
	final static int VENIT_CURENT1 = 52;
	final static int VENIT_AN_PRECEDENT1 = 53;
	final static int TIP_VENIT1 = 54;
	final static int VENIT_CURENT2 = 55;
	final static int VENIT_AN_PRECEDENT2 = 56;
	final static int TIP_VENIT2 = 57;
	final static int VENIT_CURENT3 = 58;
	final static int VENIT_AN_PRECEDENT3 = 59;
	final static int TIP_VENIT3 = 60;
	final static int CONTRACT = 61;
	final static int DATA_EXPIRARE_CONTRACT = 62;
	final static int MARIRE = 63;
	final static int CONVENTIE = 64;
	final static int BANCA_CONVENTIE = 65;
	final static int CONTURI = 66;
	final static int ISTORIC = 67;
	final static int NR_IMOBILE = 68;
	final static int PAD = 69;
	final static int ASIGURARE = 70;
	final static int IMPOZIT = 71;
	final static int NR_MASINI = 72;
	final static int RCA = 73;
	final static int CASCO = 74;
	final static int IMPOZIT_MASINA = 75;
	final static int NUMAR_COPII = 76;
	final static int NUMAR_PERSOANE_INTRETINERE = 77;
	final static int TIP_CREDIT1 = 78;
	final static int CREDITOR1 = 79;
	final static int SUMA_INITIALA1 = 80;
	final static int RATA_LUNARA1 = 81;
	final static int SOLD_CREDIT1 = 82;
	final static int DATA_CONTRACTARE1 = 83;
	final static int DATA_SCADENTA1 = 84;
	final static int REFINANTARE1 = 85;
	final static int INTARZIERE1 = 86;
	final static int INCHIDERE1 =87;
	final static int TIP_CREDIT2 = 88;
	final static int CREDITOR2 = 89;
	final static int SUMA_INITIALA2 = 90;
	final static int RATA_LUNARA2 = 91;
	final static int SOLD_CREDIT2 = 92;
	final static int DATA_CONTRACTARE2 = 93;
	final static int DATA_SCADENTA2 = 94;
	final static int REFINANTARE2 = 95;
	final static int INTARZIERE2 = 96;
	final static int INCHIDERE2 =97;
	final static int TIP_CREDIT3 = 98;
	final static int CREDITOR3 = 99;
	final static int SUMA_INITIALA3 = 100;
	final static int RATA_LUNARA3 = 101;
	final static int SOLD_CREDIT3 = 103;
	final static int DATA_CONTRACTARE3 = 103;
	final static int DATA_SCADENTA3 = 104;
	final static int REFINANTARE3 = 105;
	final static int INTARZIERE3 = 106;
	final static int INCHIDERE3 =107;
	final static int TIP_CREDIT4 = 108;
	final static int CREDITOR4 = 109;
	final static int SUMA_INITIALA4 = 110;
	final static int RATA_LUNARA4 = 111;
	final static int SOLD_CREDIT4 = 112;
	final static int DATA_CONTRACTARE4 = 113;
	final static int DATA_SCADENTA4 = 114;
	final static int REFINANTARE4 = 115;
	final static int INTARZIERE4 = 116;
	final static int INCHIDERE4 = 117;
	final static int BROKER = 118;
	final static int UNIT = 119;
	final static int ABONAMENT = 120;
			
	
	// word editing tokens - temp until implementing Client class
	
	private static String[] templateTitularTokens = {"#numeTitular", "#prenumeTitular","#CNPTitular","#emailTitular", "#IDTitular",
			"#serieIDTitular","#nrIDTitular", "#laDataTitular", "#eliberatDeTitular", "#adresaTitular", "#dataNastereTitular",
			"#localitateNastereTitular", "#resedintaTitular", "#situatieLocativaTitular", "#vechimeAdresaTitular", "#functieTitular",
			"#angajatorTitular", "#vechimeTotalaTitular", "#situatieFamilialaTitular", "#numarMembriTitular", "#telAngajatorTitular",
			"#fixTitular", "#mobilTitular", "#numeMamaTitular", "#prenumeTataTitular", "#CNPSotTitular", "#valabilPanaDataTitular",
			"#numeSotTitular", "#masinaTitular", "#studiiTitular", "#tipImobilTitular", "#tipVenitTitular", "#CUITitular", "#nrAngajatiTitular",
			"#dataInfiintareTitular", "#adresaAngajatorTitular", "#dataAngajareTitular", "#domeniuTitular", "#capitalSocietateTitular",
			"#CAENTitular", "#multinationalaTitular", "#tipSocietateTitular", "#profesieTitular", "#tipFunctieTitular",
			"#vechimeUltimAngajatorTitular", "#bonuriMasaTitular", "#venit3LuniTitular", "#venit6LuniTitular", "#venit12LuniTitular",
			"#tipVenit3LuniTitular", "#tipVenit6LuniTitular", "#tipVenit12LuniTitular", "#venitCurentTitular1", "#venitAnPrecedentTitular1",
			"#tipVenitTitular1", "#venitCurentTitular2", "#venitAnPrecedentTitular2", "#tipVenitTitular2", "#venitCurentTitular3",
			"#venitAnPrecedentTitular3", "#tipVenitTitular3", "#contractMuncaTitular", "#dataExpirareContractTitular", "#marireTitular",
			"#conventieSalarialaTitular", "#bancaConventieTitular", "#conturiBancareTitular", "#istoricCreditareTitular",
			"#nrImobileTitular", "#PADTitular", "#asigurareTitular", "#impozitTitular", "#nrMasiniTitular", "#RCATitular", "#cascoTitular",
			"#impozitMasinaTitular", "#numarCopiiTitular", "#numarPersoaneIntretinereTitular",
			
			"#tipCreditTitular1", "#creditorTitular1", "#sumaInitialaTitular1", "#rataLunaraTitular1", "#soldCreditTitular1", 
			"#dataContractareTitular1", "#dataScadentaTitular1", "#refinanteazaTitular1", "#intarzieriTitular1", "#inchidereTitular1", 
			
			"#tipCreditTitular2", "#creditorTitular2", "#sumaInitialaTitular2", "#rataLunaraTitular2", "#soldCreditTitular2", 
			"#dataContractareTitular2", "#dataScadentaTitular2", "#refinanteazaTitular2", "#intarzieriTitular2", "#inchidereTitular2", 
			
			"#tipCreditTitular3", "#creditorTitular3", "#sumaInitialaTitular3", "#rataLunaraTitular3", "#soldCreditTitular3", 
			"#dataContractareTitular3", "#dataScadentaTitular3", "#refinanteazaTitular3", "#intarzieriTitular3", "#inchidereTitular3", 
			
			"#tipCreditTitular4", "#creditorTitular4", "#sumaInitialaTitular4", "#rataLunaraTitular4", "#soldCreditTitular4", 
			"#dataContractareTitular4", "#dataScadentaTitular4", "#refinanteazaTitular4", "#intarzieriTitular4", "#inchidereTitular4", 
			"#broker", "#unit", "#abonamentTitular"}; 
	
	
	private static String[] templateCodebitorTokens = {"#numeCodebitor", "#prenumeCodebitor","#CNPCodebitor","#emailCodebitor", "#IDCodebitor",
			"#serieIDCodebitor", "#nrIDCodebitor", "#laDataCodebitor", "#eliberatDeCodebitor", "#adresaCodebitor", "#dataNastereCodebitor",
			"#localitateNastereCodebitor", "#resedintaCodebitor", "#situatieLocativaCodebitor", "#vechimeAdresaCodebitor", "#functieCodebitor",
			"#angajatorCodebitor", "#vechimeTotalaCodebitor", "#situatieFamilialaCodebitor", "#numarMembriCodebitor", "#telAngajatorCodebitor",
			"#fixCodebitor", "#mobilCodebitor", "#numeMamaCodebitor", "#prenumeTataCodebitor", "#CNPSotCodebitor", "#valabilPanaDataCodebitor",
			"#numeSotCodebitor", "#masinaCodebitor", "#studiiCodebitor", "#tipImobilCodebitor", "#tipVenitCodebitor", "#CUICodebitor", "#nrAngajatiCodebitor",
			"#dataInfiintareCodebitor", "#adresaAngajatorCodebitor", "#dataAngajareCodebitor", "#domeniuCodebitor", "#capitalSocietateCodebitor",
			"#CAENCodebitor", "#multinationalaCodebitor", "#tipSocietateCodebitor", "#profesieCodebitor", "#tipFunctieCodebitor",
			"#vechimeUltimAngajatorCodebitor", "#bonuriMasaCodebitor", "#venit3LuniCodebitor", "#venit6LuniCodebitor", "#venit12LuniCodebitor",
			"#tipVenit3LuniCodebitor", "#tipVenit6LuniCodebitor", "#tipVenit12LuniCodebitor", "#venitCurentCodebitor1", "#venitAnPrecedentCodebitor1",
			"#tipVenitCodebitor1", "#venitCurentCodebitor2", "#venitAnPrecedentCodebitor2", "#tipVenitCodebitor2", "#venitCurentCodebitor3",
			"#venitAnPrecedentCodebitor3", "#tipVenitCodebitor3", "#contractMuncaCodebitor", "#dataExpirareContractCodebitor", "#marireCodebitor",
			"#conventieSalarialaCodebitor", "#bancaConventieCodebitor", "#conturiBancareCodebitor", "#istoricCreditareCodebitor",
			"#nrImobileCodebitor", "#PADCodebitor", "#asigurareCodebitor", "#impozitCodebitor", "#nrMasiniCodebitor", "#RCACodebitor", "#cascoCodebitor",
			"#impozitMasinaCodebitor", "#numarCopiiCodebitor", "#numarPersoaneIntretinereCodebitor",
			
			"#tipCreditCodebitor1", "#creditorCodebitor1", "#sumaInitialaCodebitor1", "#rataLunaraCodebitor1", "soldCreditCodebitor1", 
			"#dataContractareCodebitor1", "#dataScadentaCodebitor1", "#refinanteazaCodebitor1", "#intarziereCodebitor1", "#inchidereCodebitor1", 
			
			"#tipCreditCodebitor2", "#creditorCodebitor2", "#sumaInitialaCodebitor2", "#rataLunaraCodebitor2", "soldCreditCodebitor2", 
			"#dataContractareCodebitor2", "#dataScadentaCodebitor2", "#refinanteazaCodebitor2", "#intarziereCodebitor2", "#inchidereCodebitor2", 
			
			"#tipCreditCodebitor3", "#creditorCodebitor3", "#sumaInitialaCodebitor3", "#rataLunaraCodebitor3", "soldCreditCodebitor3", 
			"#dataContractareCodebitor3", "#dataScadentaCodebitor3", "#refinanteazaCodebitor3", "#intarziereCodebitor3", "#inchidereCodebitor3", 
			
			"#tipCreditCodebitor4", "#creditorCodebitor4", "#sumaInitialaCodebitor4", "#rataLunaraCodebitor4", "soldCreditCodebitor4", 
			"#dataContractareCodebitor4", "#dataScadentaCodebitor4", "#refinanteazaCodebitor4", "#intarziereCodebitor4", "#inchidereCodebitor4", 
			"#broker", "#unit", "#abonamentCodebitor"};  
	
	
	private static String[] informationTitularTokens = new String[templateTitularTokens.length];
	private static String[] informationCodebitorTokens = new String[templateCodebitorTokens.length];
		
	//menuBar
	private final JMenuBar menuBar;
		// menu choices
		// File menu
		private final JMenu file;  
			// File submenu 
			private final JMenuItem fileNew, fileOpen, fileOpenCodebitor, fileSave, fileSaveCodebitor , fileSaveAs, fileSaveAsCodebitor,
			fileQuit;
		// Print menu
		private final JMenu print;
			// Print submenu 
			private final JMenuItem printFisk, printFisa, printAlpha, printBcr, printCetelem, printGaranti, printIdea, printOtp, 
			printPiraeus, printUnicredit;
		// Help menu
		private final JMenu help;
			// Help submenu 
			private final JMenuItem helpHelp, helpAbout;
	
	// info Broker
	private final Container infoBroker;
		// components
		private final JLabel labelBroker;
		static private JTextField inputBroker;
		private final JLabel labelUnit;
		static private JTextField inputUnit;
		static private JCheckBox areCodebitor;

	// tabbed input area
	private final JTabbedPane tabbedPane;
		//tabs
		// tab1
		private final JPanel solicitant;
			// components
			// row1
			private final JLabel numeTitular, prenumeTitular, numeMamaTitular, prenumeTataTitular; 
			static private JTextField inputNumeTitular, inputPrenumeTitular, inputNumeMamaTitular, inputPrenumeTataTitular;
			// row2
			private final JLabel dataNastereTitular, localitateNastereTitular; 
			static private JTextField inputDataNastereTitular, inputLocalitateNastereTitular;
			static private JComboBox<String> IDTitular;
			static private final String[] IDType = {"CI", "BI", "P"};
			private final JLabel dataEliberareTitular, vechimeAdresaTitular; 
			static private JTextField inputIDTitular, inputDataEliberareTitular, inputVechimeAdresaTitular; 
			// row3
			private final JLabel CNPTitular, CNPSotTitular, eliberatDeTitular, valabilPanaDataTitular;
			static private JTextField inputCNPTitular, inputCNPSotTitular, inputEliberatDeTitular, inputValabilPanaDataTitular;
			// row4
			private final JLabel adresaTitular;
			static private JTextField inputAdresaTitular;
			// row5
			private final JLabel resedintaTitular, numeSotTitular;
			static private JTextField inputResedintaTitular, inputNumeSotTitular;
			// row6
			private final JLabel fixTitular, mobilTitular;
			static private JTextField inputFixTitular, inputMobilTitular;
			static private JComboBox<String> inputAbonamentTitular;
			static private final String[] abonamentType = {"Cartela", "Abonament"};
			private final JLabel emailTitular; 
			static private JTextField inputEmailTitular; 
			static private JCheckBox masinaTitular;
			// row7
			private final JLabel studiiTitular, situatieLocativaTitular, tipImobilTitular;
			static private JComboBox<String> inputStudiiTitular;
			static private final String[] studiiType = {"Primare", "Gimnaziu", "Profesionala", "Liceu", "Colegiu", "Universitate", "Postuniversitare    "};
			static private JComboBox<String> inputSituatieLocativaTitular;
			static private final String[] situatieLocativaType = {"Proprietar fara ipoteca    ", "Proprietar cu ipoteca", "Locuita de serviciu",
														  "Cu parintii", "Chirie la stat", "Chirie particular", "Altele"};
			static private JComboBox<String> inputTipImobilTitular;
			static private final String[] tipImobilType = {"Apartament - 1 camera", "Apartament 2 - 3 camere", "Apartament peste 4 camere    ", "Vila"};
			// row8
			private final JLabel angajatorTitular, CUITitular, nrAngajatiTitular, dataInfiintareTitular, telAngajatorTitular;
			static private JTextField inputAngajatorTitular, inputCUITitular, inputNrAngajatiTitular, inputDataInfiintareTitular, 
									 inputTelAngajatorTitular;
			// row9
			private final JLabel adresaAngajatorTitular, dataAngajareTitular, vechimeTotalaTitular, vechimeUltimAngajatorTitular;
			static private JTextField inputAdresaAngajatorTitular, inputDataAngajareTitular, inputVechimeTotalaTitular, 
									 inputVechimeUltimAngajatorTitular;
			// row10
			private final JLabel capitalTitular, tipSocietateTitular, CAENTitular, domeniuTitular;
			static private JComboBox<String> inputCapitalTitular;
			static private final String[] capitalType = {"De Stat", "Sector Bugetar", "Privat romanesc", "Privat mixt", "Privat Strain"};
			static private JComboBox<String> inputTipSocietateTitular;
			static private final String[] societateType = {"SA", "SRL", "RA", "PFA", "Altele"};
			static private JTextField inputCAENTitular, inputDomeniuTitular;
			static private JCheckBox multinationalaTitular;
			// row11
			private final JLabel tipFunctieTitular, functieTitular, profesieTitular;
			static private JTextField inputFunctieTitular, inputProfesieTitular;
			static private JComboBox<String> inputTipFunctieTitular;
			static private final String[] functieType = {"Top Management", "Sef Departament", "Personal studii sup.", "Personal studii medii",
												 "Personal necalificat"};
			// row12
			private final JLabel venitCurentTitular1, venitAnPrecedentTitular1, alteVenituriTitular;
			static private JTextField inputVenitCurentTitular1, inputVenitAnPrecedentTitular1;
			static private JComboBox<String> inputTipVenitTitular1;
			static private final String[] venitType = {"Salariu", "Dividende","Pensie", "PFA", "Chirii", "Strainatate"};
			// row13
			private final JLabel venitCurentTitular2, venitAnPrecedentTitular2, venit3LuniTitular, venit6LuniTitular, venit12LuniTitular;
			static private JTextField inputVenitCurentTitular2, inputVenitAnPrecedentTitular2, inputVenit3LuniTitular, inputVenit6LuniTitular, 
									 inputVenit12LuniTitular;
			static private JComboBox<String> inputTipVenitTitular2;
			// row14
			private final JLabel venitCurentTitular3, venitAnPrecedentTitular3, tipVenit3LuniTitular, tipVenit6LuniTitular, tipVenit12LuniTitular;
			static private JTextField inputVenitCurentTitular3, inputVenitAnPrecedentTitular3, inputTipVenit3LuniTitular, inputTipVenit6LuniTitular, 
									 inputTipVenit12LuniTitular;
			static private JComboBox<String> inputTipVenitTitular3;
			// row15
			private final JLabel bonuriMasaTitular, contractMuncaTitular, dataExpirareContractTitular;
			static private JTextField inputBonuriMasaTitular, inputDataExpirareContractTitular;
			static private JCheckBox marireTitular;
			static private JComboBox<String> inputContractMuncaTitular;
			static private final String[] contractType = {"Contract determinat", "Contract nedeterminat", "Part-time", "Liber profesionist"};
			// row16
			static private JCheckBox conventieSalarialaTitular, istoricCreditareTitular;
			private final JLabel conturiBanciTitular;
			static private JTextField inputBancaConventieTitular, inputConturiBanciTitular;
			// row17
			private final JLabel numarImobileTitular, PADTitular, asigurareTitular, impozitTitular, numarMasiniTitular, RCATitular, cascoTitular, 
			impozitMasinaTitular;
			static private JTextField inputNumarImobileTitular, inputPADTitular, inputAsigurareTitular, inputImpozitTitular, inputNumarMasiniTitular, 
			                         inputRCATitular, inputCascoTitular, inputImpozitMasinaTitular;
			// row18
			private final JLabel numarMembriFamilieTitular, numarCopiiTitular, numarPersoaneIntretinereTitular;
			static private JTextField inputNumarMembriFamilieTitular, inputNumarCopiiTitular, inputNumarPersoaneIntretinereTitular;
			static private JComboBox<String> inputSituatieFamilialaTitular;
			static private final String[] situatieFamilialaType = {"Necasatorit", "Casatorit", "Divortat", "Vaduv"};
			// row19
			private final JLabel tipCreditTitular, creditorTitular, sumaInitialaTitular, rataLunaraTitular, soldCreditTitular, 
								 dataContractareTitular, scadentaTitular;
			// row20
			static private JTextField inputTipCreditTitular1, inputCreditorTitular1, inputSumaInitialaTitular1, inputRataLunaraTitular1, 
									 inputSoldCreditTitular1, inputDataContractareTitular1, inputScadentaTitular1;
			static private JCheckBox refinanteazaTitular1, intarzieriTitular1, inchideTitular1;
			// row21
			static private JTextField inputTipCreditTitular2, inputCreditorTitular2, inputSumaInitialaTitular2, inputRataLunaraTitular2, 
									 inputSoldCreditTitular2, inputDataContractareTitular2, inputScadentaTitular2;
			static private JCheckBox refinanteazaTitular2, intarzieriTitular2, inchideTitular2;
			// row22
			static private JTextField inputTipCreditTitular3, inputCreditorTitular3, inputSumaInitialaTitular3, inputRataLunaraTitular3, 
			 						 inputSoldCreditTitular3, inputDataContractareTitular3, inputScadentaTitular3;
			static private JCheckBox refinanteazaTitular3, intarzieriTitular3, inchideTitular3;
			// row23
			static private JTextField inputTipCreditTitular4, inputCreditorTitular4, inputSumaInitialaTitular4, inputRataLunaraTitular4, 
			 						 inputSoldCreditTitular4, inputDataContractareTitular4, inputScadentaTitular4;
			static private JCheckBox refinanteazaTitular4, intarzieriTitular4, inchideTitular4;
										 
			
			
		// tab2
		private JPanel codebitor;
		// components
					// row1
			private final JLabel numeCodebitor, prenumeCodebitor, numeMamaCodebitor, prenumeTataCodebitor; 
			static private JTextField inputNumeCodebitor, inputPrenumeCodebitor, inputNumeMamaCodebitor, inputPrenumeTataCodebitor;
			// row2
			private final JLabel dataNastereCodebitor, localitateNastereCodebitor; 
			static private JTextField inputDataNastereCodebitor, inputLocalitateNastereCodebitor;
			static private JComboBox<String> IDCodebitor;
			private final JLabel dataEliberareCodebitor, vechimeAdresaCodebitor; 
			static private JTextField inputIDCodebitor, inputDataEliberareCodebitor, inputVechimeAdresaCodebitor; 
			// row3
			private final JLabel CNPCodebitor, CNPSotCodebitor, eliberatDeCodebitor, valabilPanaDataCodebitor;
			static private JTextField inputCNPCodebitor, inputCNPSotCodebitor, inputEliberatDeCodebitor, inputValabilPanaDataCodebitor;
			// row4
			private final JLabel adresaCodebitor;
			static private JTextField inputAdresaCodebitor;
			// row5
			private final JLabel resedintaCodebitor, numeSotCodebitor;
			static private JTextField inputResedintaCodebitor, inputNumeSotCodebitor;
			// row6
			private final JLabel fixCodebitor, mobilCodebitor;
			static private JTextField inputFixCodebitor, inputMobilCodebitor;
			static private JComboBox<String> inputAbonamentCodebitor;
			private final JLabel emailCodebitor; 
			static private JTextField inputEmailCodebitor; 
			static private JCheckBox masinaCodebitor;
			// row7
			private final JLabel studiiCodebitor, situatieLocativaCodebitor, tipImobilCodebitor;
			static private JComboBox<String> inputStudiiCodebitor;
			static private JComboBox<String> inputSituatieLocativaCodebitor;
			static private JComboBox<String> inputTipImobilCodebitor;
			// row8
			private final JLabel angajatorCodebitor, CUICodebitor, nrAngajatiCodebitor, dataInfiintareCodebitor, telAngajatorCodebitor;
			static private JTextField inputAngajatorCodebitor, inputCUICodebitor, inputNrAngajatiCodebitor, inputDataInfiintareCodebitor, 
					 inputTelAngajatorCodebitor;
			// row9
			private final JLabel adresaAngajatorCodebitor, dataAngajareCodebitor, vechimeTotalaCodebitor, vechimeUltimAngajatorCodebitor;
			static private JTextField inputAdresaAngajatorCodebitor, inputDataAngajareCodebitor, inputVechimeTotalaCodebitor, 
					 inputVechimeUltimAngajatorCodebitor;
			// row10
			private final JLabel capitalCodebitor, tipSocietateCodebitor, CAENCodebitor, domeniuCodebitor;
			static private JComboBox<String> inputCapitalCodebitor;
			static private JComboBox<String> inputTipSocietateCodebitor;
			static private JTextField inputCAENCodebitor, inputDomeniuCodebitor;
			static private JCheckBox multinationalaCodebitor;
			// row11
			private final JLabel tipFunctieCodebitor, functieCodebitor, profesieCodebitor;
			static private JTextField inputFunctieCodebitor, inputProfesieCodebitor;
			static private JComboBox<String> inputTipFunctieCodebitor;
			// row12
			private final JLabel venitCurentCodebitor1, venitAnPrecedentCodebitor1, alteVenituriCodebitor;
			static private JTextField inputVenitCurentCodebitor1, inputVenitAnPrecedentCodebitor1;
			static private JComboBox<String> inputTipVenitCodebitor1;
			// row13
			private final JLabel venitCurentCodebitor2, venitAnPrecedentCodebitor2, venit3LuniCodebitor, venit6LuniCodebitor, venit12LuniCodebitor;
			static private JTextField inputVenitCurentCodebitor2, inputVenitAnPrecedentCodebitor2, inputVenit3LuniCodebitor, inputVenit6LuniCodebitor, 
							 inputVenit12LuniCodebitor;
			static private JComboBox<String> inputTipVenitCodebitor2;
			// row14
			private final JLabel venitCurentCodebitor3, venitAnPrecedentCodebitor3, tipVenit3LuniCodebitor, tipVenit6LuniCodebitor, tipVenit12LuniCodebitor;
			static private JTextField inputVenitCurentCodebitor3, inputVenitAnPrecedentCodebitor3, inputTipVenit3LuniCodebitor, inputTipVenit6LuniCodebitor, 
							 inputTipVenit12LuniCodebitor;
			static private JComboBox<String> inputTipVenitCodebitor3;
			// row15
			private final JLabel bonuriMasaCodebitor, contractMuncaCodebitor, dataExpirareContractCodebitor;
			static private JTextField inputBonuriMasaCodebitor, inputDataExpirareContractCodebitor;
			static private JCheckBox marireCodebitor;
			static private JComboBox<String> inputContractMuncaCodebitor;
			// row16
			static private JCheckBox conventieSalarialaCodebitor, istoricCreditareCodebitor;
			private final JLabel conturiBanciCodebitor;
			static private JTextField inputBancaConventieCodebitor, inputConturiBanciCodebitor;
			// row17
			private final JLabel numarImobileCodebitor, PADCodebitor, asigurareCodebitor, impozitCodebitor, numarMasiniCodebitor, RCACodebitor, cascoCodebitor, 
			impozitMasinaCodebitor;
			static private JTextField inputNumarImobileCodebitor, inputPADCodebitor, inputAsigurareCodebitor, inputImpozitCodebitor, inputNumarMasiniCodebitor, 
			                         inputRCACodebitor, inputCascoCodebitor, inputImpozitMasinaCodebitor;
			// row18
			private final JLabel numarMembriFamilieCodebitor, numarCopiiCodebitor, numarPersoaneIntretinereCodebitor;
			static private JTextField inputNumarMembriFamilieCodebitor, inputNumarCopiiCodebitor, inputNumarPersoaneIntretinereCodebitor;
			static private JComboBox<String> inputSituatieFamilialaCodebitor;
			// row19
			private final JLabel tipCreditCodebitor, creditorCodebitor, sumaInitialaCodebitor, rataLunaraCodebitor, soldCreditCodebitor, 
						 dataContractareCodebitor, scadentaCodebitor;
			// row20
			static private JTextField inputTipCreditCodebitor1, inputCreditorCodebitor1, inputSumaInitialaCodebitor1, inputRataLunaraCodebitor1, 
							 inputSoldCreditCodebitor1, inputDataContractareCodebitor1, inputScadentaCodebitor1;
			static private JCheckBox refinanteazaCodebitor1, intarzieriCodebitor1, inchideCodebitor1;
			// row21
			static private JTextField inputTipCreditCodebitor2, inputCreditorCodebitor2, inputSumaInitialaCodebitor2, inputRataLunaraCodebitor2, 
							 inputSoldCreditCodebitor2, inputDataContractareCodebitor2, inputScadentaCodebitor2;
			static private JCheckBox refinanteazaCodebitor2, intarzieriCodebitor2, inchideCodebitor2;
			// row22
			static private JTextField inputTipCreditCodebitor3, inputCreditorCodebitor3, inputSumaInitialaCodebitor3, inputRataLunaraCodebitor3, 
			 				 inputSoldCreditCodebitor3, inputDataContractareCodebitor3, inputScadentaCodebitor3;
			static private JCheckBox refinanteazaCodebitor3, intarzieriCodebitor3, inchideCodebitor3;
			// row23
			static private JTextField inputTipCreditCodebitor4, inputCreditorCodebitor4, inputSumaInitialaCodebitor4, inputRataLunaraCodebitor4, 
			 				 inputSoldCreditCodebitor4, inputDataContractareCodebitor4, inputScadentaCodebitor4;
			static private JCheckBox refinanteazaCodebitor4, intarzieriCodebitor4, inchideCodebitor4;		
	
	// InfoBar
	static JLabel infoLabel;
		
	public InputScreen()
	{
		super("Client");
		
		//initialize JMenuBar
		menuBar = new JMenuBar();
		
			// initialize File JMenu 
			file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			
			MenuHandler menuHandler = new MenuHandler();
			
			// add submenus
			file.addSeparator();
				fileNew = new JMenuItem("Nou");
				fileNew.addActionListener(menuHandler);
				file.add(fileNew);
				
				fileOpen = new JMenuItem("Deschide");
				fileOpen.addActionListener(menuHandler);
				file.add(fileOpen);
				
				fileOpenCodebitor = new JMenuItem("Deschide Codebitor");
				fileOpenCodebitor.addActionListener(menuHandler);
				file.add(fileOpenCodebitor);
				
				fileSave = new JMenuItem("Salveaza ");
				fileSave.addActionListener(menuHandler);
				file.add(fileSave);
				
				fileSaveCodebitor = new JMenuItem("Salveaza Codebitor");
				fileSaveCodebitor.addActionListener(menuHandler);
				file.add(fileSaveCodebitor);
				
				fileSaveAs = new JMenuItem("Salveaza ca");
				fileSaveAs.addActionListener(menuHandler);
				//file.add(fileSaveAs);
				
				fileSaveAsCodebitor = new JMenuItem("Salveaza Codebitor ca");
				fileSaveAsCodebitor.addActionListener(menuHandler);
				//file.add(fileSaveAsCodebitor);
				
				fileQuit = new JMenuItem("Inchide");
				fileQuit.addActionListener(menuHandler);
				file.add(fileQuit);
			
			menuBar.add(file);
			
			// initialize Print JMenu
			print = new JMenu("Print");
			print.setMnemonic(KeyEvent.VK_P);
			
			// add submenus
			print.addSeparator();
				printFisk = new JMenuItem("Fisk");
				printFisk.addActionListener(menuHandler);
				print.add(printFisk);
				
				printFisa = new JMenuItem("Fisa");
				printFisa.addActionListener(menuHandler);
				print.add(printFisa);
				
				printAlpha = new JMenuItem("Alpha");
				printAlpha.addActionListener(menuHandler);
				//print.add(printAlpha); - commented out because no files yet
				
				printBcr = new JMenuItem("BCR");
				printBcr.addActionListener(menuHandler);
				print.add(printBcr);
				
				printCetelem = new JMenuItem("BNP Paribas");
				printCetelem.addActionListener(menuHandler);
				print.add(printCetelem);
				
				printGaranti = new JMenuItem("Garanti");
				printGaranti.addActionListener(menuHandler);
				print.add(printGaranti);
				
				printIdea = new JMenuItem("Idea");
				printIdea.addActionListener(menuHandler);
				print.add(printIdea);
				
				printOtp = new JMenuItem("OTP");
				printOtp.addActionListener(menuHandler);
				print.add(printOtp);
				
				printPiraeus = new JMenuItem("Piraeus");
				printPiraeus.addActionListener(menuHandler);
				//print.add(printPiraeus); - commented out because no files yet
				
				printUnicredit = new JMenuItem("Unicredit");
				printUnicredit.addActionListener(menuHandler);
				print.add(printUnicredit);
	
		menuBar.add(print);
			
			// initialize Help JMenu
			help = new JMenu("Ajutor");
			help.setMnemonic(KeyEvent.VK_A);
			
			// add submenus
			help.addSeparator();
				helpHelp = new JMenuItem("Ajutor");
				helpHelp.addActionListener(menuHandler);
				help.add(helpHelp);
				
				helpAbout = new JMenuItem("Despre...");
				helpAbout.addActionListener(menuHandler);
				help.add(helpAbout);
		
		menuBar.add(help);
				
		// add menu bar to Frame
		this.setJMenuBar(menuBar);
		
		setLayout(new BorderLayout());
		Font font = new Font("Serif", Font.PLAIN, 10);
		
				
		// initialize infoBroker container
		infoBroker = new Container();
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
		flow.setVgap(FLOWLAYOUT_VGAP);
		infoBroker.setLayout(flow);
			
			// initialize infoBroker components
			labelBroker = new JLabel("Broker");
			labelBroker.setFont(font);
			infoBroker.add(labelBroker);
			
			inputBroker = new JTextField(20);
			inputBroker.setFont(font);
			infoBroker.add(inputBroker);
			
			labelUnit = new JLabel("Unit");
			labelUnit.setFont(font);
			infoBroker.add(labelUnit);
			
			inputUnit = new JTextField(3);
			inputUnit.setFont(font);
			infoBroker.add(inputUnit);
			
			areCodebitor = new JCheckBox("Codebitor?");
			areCodebitor.setFont(font);
			areCodebitor.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent actionEvent)
						{
							JCheckBox temp = (JCheckBox)actionEvent.getSource();
							if(temp.isSelected())
								tabbedPane.setEnabledAt(1, true);
							
							if(!temp.isSelected())
								tabbedPane.setEnabledAt(1, false);			
						}
					});
			infoBroker.add(areCodebitor);
		
		// add infoBroker container to Frame
		this.add(infoBroker,BorderLayout.NORTH);
		
		// initialize tabbed inputArea
		tabbedPane = new JTabbedPane();
			
			// initialize inputArea components
			solicitant = new JPanel();
			solicitant.setLayout(flow);
				//row1
				numeTitular = new JLabel("Nume");
				numeTitular.setFont(font);
				solicitant.add(numeTitular);
								
				inputNumeTitular = new JTextField(10);
				solicitant.add(inputNumeTitular);
							
				prenumeTitular = new JLabel("Prenume");
				prenumeTitular.setFont(font);
				solicitant.add(prenumeTitular);
								
				inputPrenumeTitular = new JTextField(10);
				solicitant.add(inputPrenumeTitular);
								
				numeMamaTitular = new JLabel("<html><center>" + "Nume" + "<br>" + "mama" + "</center></html>");
				numeMamaTitular.setFont(font);
				solicitant.add(numeMamaTitular);
					
				inputNumeMamaTitular = new JTextField(10);
				solicitant.add(inputNumeMamaTitular);
								
				prenumeTataTitular = new JLabel("<html><center>" + "Prenume" + "<br>" + "tata" + "</center></html>");
				prenumeTataTitular.setFont(font);
				solicitant.add(prenumeTataTitular);
							
				inputPrenumeTataTitular = new JTextField(10);
				solicitant.add(inputPrenumeTataTitular);
				
				//row2
				dataNastereTitular = new JLabel("<html><center>" + "Data" + "<br>" + "nastere" + "</center></html>");
				dataNastereTitular.setFont(font);
				solicitant.add(dataNastereTitular);
							
				inputDataNastereTitular = new JTextField(6);
				solicitant.add(inputDataNastereTitular);
							
				localitateNastereTitular = new JLabel("<html><center>" + "Localitate" + "<br>" + "nastere" + "</center></html>");
				localitateNastereTitular.setFont(font);
				solicitant.add(localitateNastereTitular);
							
				inputLocalitateNastereTitular = new JTextField(10);
				solicitant.add(inputLocalitateNastereTitular);
							
				IDTitular = new JComboBox<String>(IDType);
				
				solicitant.add(IDTitular);
							
				inputIDTitular = new JTextField(6);
				solicitant.add(inputIDTitular);
								
				dataEliberareTitular = new JLabel("<html><center>" + "Data" + "<br>" + "eliberare" + "</center></html>");
				dataEliberareTitular.setFont(font);
				solicitant.add(dataEliberareTitular);
							
				inputDataEliberareTitular = new JTextField(6);
				solicitant.add(inputDataEliberareTitular);
							
				vechimeAdresaTitular = new JLabel("<html><center>" + "Vechime" + "<br>" + "adresa" + "</center></html>");
				vechimeAdresaTitular.setFont(font);
				solicitant.add(vechimeAdresaTitular);
						
				inputVechimeAdresaTitular = new JTextField(6);
				solicitant.add(inputVechimeAdresaTitular);
			
				// row3
				CNPTitular = new JLabel("CNP");
				CNPTitular.setFont(font);
				solicitant.add(CNPTitular);
						
				inputCNPTitular = new JTextField(11);
				solicitant.add(inputCNPTitular);
						
				CNPSotTitular = new JLabel("<html><center>" + "CNP" + "<br>" + "sot/sotie" + "</center></html>");
				CNPSotTitular.setFont(font);
				solicitant.add(CNPSotTitular);
						
				inputCNPSotTitular = new JTextField(11);
				solicitant.add(inputCNPSotTitular);
						
				eliberatDeTitular = new JLabel("<html><center>" + "elib." + "<br>" + "de" + "</center></html>");
				eliberatDeTitular.setFont(font);
				solicitant.add(eliberatDeTitular);
						
				inputEliberatDeTitular = new JTextField(11);
				solicitant.add(inputEliberatDeTitular);
						
				valabilPanaDataTitular = new JLabel("<html><center>" + "data" + "<br>" + "valab" + "</center></html>");
				valabilPanaDataTitular.setFont(font);
				solicitant.add(valabilPanaDataTitular);
							
				inputValabilPanaDataTitular = new JTextField(10);
				solicitant.add(inputValabilPanaDataTitular);
					
				// row4
				adresaTitular = new JLabel("Adresa");
				adresaTitular.setFont(font);
				solicitant.add(adresaTitular);
						
				inputAdresaTitular = new JTextField(52);
				solicitant.add(inputAdresaTitular);
						
				// row5
				resedintaTitular = new JLabel("Resedinta");
				resedintaTitular.setFont(font);
				solicitant.add(resedintaTitular);
						
				inputResedintaTitular = new JTextField(32);
				solicitant.add(inputResedintaTitular);
				
				numeSotTitular = new JLabel("<html><center>" + "Nume" + "<br>" + "sot/sotie" + "</center></html>");
				numeSotTitular.setFont(font);
				solicitant.add(numeSotTitular);
						
				inputNumeSotTitular = new JTextField(15);
				solicitant.add(inputNumeSotTitular);
				
				// row6
				fixTitular = new JLabel("Fix");
				fixTitular.setFont(font);
				solicitant.add(fixTitular);
						
				inputFixTitular = new JTextField(9);
				solicitant.add(inputFixTitular);
								
				mobilTitular = new JLabel("Mobil");
				mobilTitular.setFont(font);
				solicitant.add(mobilTitular);
						
				inputMobilTitular = new JTextField(9);
				solicitant.add(inputMobilTitular);
				
				inputAbonamentTitular = new JComboBox<String>(abonamentType);
				solicitant.add(inputAbonamentTitular);
				
				emailTitular = new JLabel("Email");
				emailTitular.setFont(font);
				solicitant.add(emailTitular);
				
				inputEmailTitular = new JTextField(14);
				solicitant.add(inputEmailTitular);
				
				masinaTitular = new JCheckBox("Masina");
				masinaTitular.setFont(font);
				solicitant.add(masinaTitular);
				
				// row7
				studiiTitular = new JLabel("Studii");
				studiiTitular.setFont(font);
				solicitant.add(studiiTitular);
				
				inputStudiiTitular = new JComboBox<String>(studiiType);
				solicitant.add(inputStudiiTitular);
				
				situatieLocativaTitular = new JLabel("<html><center>" + "Situatie" + "<br>" + "locativa" + "</center></html>");
				situatieLocativaTitular.setFont(font);
				solicitant.add(situatieLocativaTitular);
				
				inputSituatieLocativaTitular = new JComboBox<String>(situatieLocativaType);
				solicitant.add(inputSituatieLocativaTitular);
				
				tipImobilTitular = new JLabel("<html><center>" + "Tip" + "<br>" + "imobil" + "</center></html>");
				tipImobilTitular.setFont(font);
				solicitant.add(tipImobilTitular);
				
				inputTipImobilTitular = new JComboBox<String>(tipImobilType);
				solicitant.add(inputTipImobilTitular);
				
				// row8
				angajatorTitular = new JLabel("Angajator");
				angajatorTitular.setFont(font);
				solicitant.add(angajatorTitular);
				
				inputAngajatorTitular = new JTextField(14);
				solicitant.add(inputAngajatorTitular);
				
				CUITitular = new JLabel("CUI");
				CUITitular.setFont(font);
				solicitant.add(CUITitular);
				
				inputCUITitular = new JTextField(5);
				solicitant.add(inputCUITitular);
				
				nrAngajatiTitular = new JLabel("<html><center>" + "Nr" + "<br>" + "angajati" + "</center></html>");
				nrAngajatiTitular.setFont(font);
				solicitant.add(nrAngajatiTitular);
				
				inputNrAngajatiTitular = new JTextField(3);
				solicitant.add(inputNrAngajatiTitular);
				
				dataInfiintareTitular = new JLabel("<html><center>" + "Data" + "<br>" + "infiintare" + "</center></html>");
				dataInfiintareTitular.setFont(font);
				solicitant.add(dataInfiintareTitular);
				
				inputDataInfiintareTitular = new JTextField(6);
				solicitant.add(inputDataInfiintareTitular);
				
				telAngajatorTitular = new JLabel("<html><center>" + "Telefon" + "<br>" + "fix" + "</center></html>");
				telAngajatorTitular.setFont(font);
				solicitant.add(telAngajatorTitular);
				
				inputTelAngajatorTitular = new JTextField(8);
				solicitant.add(inputTelAngajatorTitular);
				
				// row9
				adresaAngajatorTitular = new JLabel("Adresa");
				adresaAngajatorTitular.setFont(font);
				solicitant.add(adresaAngajatorTitular);
				
				inputAdresaAngajatorTitular = new JTextField(23);
				solicitant.add(inputAdresaAngajatorTitular);
				
				dataAngajareTitular = new JLabel("<html><center>" + "Data" + "<br>" + "Angajare" + "</center></html>");
				dataAngajareTitular.setFont(font);
				solicitant.add(dataAngajareTitular);
				
				inputDataAngajareTitular = new JTextField(6);
				solicitant.add(inputDataAngajareTitular);
				
				vechimeTotalaTitular = new JLabel("<html><center>" + "Vechime" + "<br>" + "totala (luni)" + "</center></html>");
				vechimeTotalaTitular.setFont(font);
				solicitant.add(vechimeTotalaTitular);
				
				inputVechimeTotalaTitular = new JTextField(3);
				solicitant.add(inputVechimeTotalaTitular);
				
				vechimeUltimAngajatorTitular = new JLabel("<html><center>" + "Vechime" + "<br>" + "ultim angajator" + "</center></html>");
				vechimeUltimAngajatorTitular.setFont(font);
				solicitant.add(vechimeUltimAngajatorTitular);
				
				inputVechimeUltimAngajatorTitular = new JTextField(3);
				solicitant.add(inputVechimeUltimAngajatorTitular);
				
				// row10
				capitalTitular = new JLabel("Capital");
				capitalTitular.setFont(font);
				solicitant.add(capitalTitular);
				
				inputCapitalTitular = new JComboBox<String>(capitalType);
				solicitant.add(inputCapitalTitular);
				
				tipSocietateTitular = new JLabel("<html><center>" + "Tip" + "<br>" + "societate" + "</center></html>");
				tipSocietateTitular.setFont(font);
				solicitant.add(tipSocietateTitular);
				
				inputTipSocietateTitular = new JComboBox<String>(societateType);
				solicitant.add(inputTipSocietateTitular);
				
				CAENTitular = new JLabel("<html><center>" + "Cod" + "<br>" + "CAEN" + "</center></html>");
				CAENTitular.setFont(font);
				solicitant.add(CAENTitular);
				
				inputCAENTitular = new JTextField(4);
				solicitant.add(inputCAENTitular);
				
				multinationalaTitular = new JCheckBox("Multinationala");
				multinationalaTitular.setFont(font);
				solicitant.add(multinationalaTitular);
				
				domeniuTitular = new JLabel("<html><center>" + "Domeniu" + "<br>" + "activitate" + "</center></html>");
				domeniuTitular.setFont(font);
				solicitant.add(domeniuTitular);
				
				inputDomeniuTitular = new JTextField(11);
				solicitant.add(inputDomeniuTitular);
				
				// row11
				tipFunctieTitular = new JLabel("Functie");
				tipFunctieTitular.setFont(font);
				solicitant.add(tipFunctieTitular);
				
				inputTipFunctieTitular = new JComboBox<String>(functieType);
				solicitant.add(inputTipFunctieTitular);
				
				functieTitular = new JLabel("<html><center>" + "Functie" + "<br>" + "actuala" + "</center></html>");
				functieTitular.setFont(font);
				solicitant.add(functieTitular);
				
				inputFunctieTitular = new JTextField(15);
				solicitant.add(inputFunctieTitular);
				
				profesieTitular = new JLabel("<html><center>" + "Profesie" + "<br>" + "cf. studii" + "</center></html>");
				profesieTitular.setFont(font);
				solicitant.add(profesieTitular);
				
				inputProfesieTitular = new JTextField(15);
				solicitant.add(inputProfesieTitular);
				
				// row12
				venitCurentTitular1 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an curent" + "</center></html>");
				venitCurentTitular1.setFont(font);
				solicitant.add(venitCurentTitular1);
				
				inputVenitCurentTitular1 = new JTextField(4);
				solicitant.add(inputVenitCurentTitular1);
				
				venitAnPrecedentTitular1 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an precedent" + "</center></html>");
				venitAnPrecedentTitular1.setFont(font);
				solicitant.add(venitAnPrecedentTitular1);
				
				inputVenitAnPrecedentTitular1 = new JTextField(4);
				solicitant.add(inputVenitAnPrecedentTitular1);
				
				inputTipVenitTitular1 = new JComboBox<String>(venitType);
				solicitant.add(inputTipVenitTitular1);
				
				alteVenituriTitular = new JLabel("Alte venituri aditionale salariului (neincluse la veniturile din tabel.)");
				alteVenituriTitular.setFont(font);
				solicitant.add(alteVenituriTitular);
				
				// row13
				venitCurentTitular2 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an curent" + "</center></html>");
				venitCurentTitular2.setFont(font);
				solicitant.add(venitCurentTitular2);
				
				inputVenitCurentTitular2 = new JTextField(4);
				solicitant.add(inputVenitCurentTitular2);
				
				venitAnPrecedentTitular2 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an precedent" + "</center></html>");
				venitAnPrecedentTitular2.setFont(font);
				solicitant.add(venitAnPrecedentTitular2);
				
				inputVenitAnPrecedentTitular2 = new JTextField(4);
				solicitant.add(inputVenitAnPrecedentTitular2);
				
				inputTipVenitTitular2 = new JComboBox<String>(venitType);
				solicitant.add(inputTipVenitTitular2);
				
				venit3LuniTitular = new JLabel("3 luni");
				venit3LuniTitular.setFont(font);
				solicitant.add(venit3LuniTitular);
				
				inputVenit3LuniTitular = new JTextField(5);
				solicitant.add(inputVenit3LuniTitular);
				
				venit6LuniTitular = new JLabel("6 luni");
				venit6LuniTitular.setFont(font);
				solicitant.add(venit6LuniTitular);
				
				inputVenit6LuniTitular = new JTextField(5);
				solicitant.add(inputVenit6LuniTitular);
				
				venit12LuniTitular = new JLabel("12 luni");
				venit12LuniTitular.setFont(font);
				solicitant.add(venit12LuniTitular);
				
				inputVenit12LuniTitular = new JTextField(5);
				solicitant.add(inputVenit12LuniTitular);
				
				// row14
				venitCurentTitular3 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an curent" + "</center></html>");
				venitCurentTitular3.setFont(font);
				solicitant.add(venitCurentTitular3);
				
				inputVenitCurentTitular3 = new JTextField(4);
				solicitant.add(inputVenitCurentTitular3);
				
				venitAnPrecedentTitular3 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an precedent" + "</center></html>");
				venitAnPrecedentTitular3.setFont(font);
				solicitant.add(venitAnPrecedentTitular3);
				
				inputVenitAnPrecedentTitular3 = new JTextField(4);
				solicitant.add(inputVenitAnPrecedentTitular3);
				
				inputTipVenitTitular3 = new JComboBox<String>(venitType);
				solicitant.add(inputTipVenitTitular3);
				
				tipVenit3LuniTitular = new JLabel("   tip  ");
				tipVenit3LuniTitular.setFont(font);
				solicitant.add(tipVenit3LuniTitular);
				
				inputTipVenit3LuniTitular = new JTextField(5);
				solicitant.add(inputTipVenit3LuniTitular);
				
				tipVenit6LuniTitular = new JLabel("  tip  ");
				tipVenit6LuniTitular.setFont(font);
				solicitant.add(tipVenit6LuniTitular);
				
				inputTipVenit6LuniTitular = new JTextField(5);
				solicitant.add(inputTipVenit6LuniTitular);
				
				tipVenit12LuniTitular = new JLabel("   tip  ");
				tipVenit12LuniTitular.setFont(font);
				solicitant.add(tipVenit12LuniTitular);
				
				inputTipVenit12LuniTitular = new JTextField(5);
				solicitant.add(inputTipVenit12LuniTitular);
				
				// row15
				bonuriMasaTitular = new JLabel("<html><center>" + "Bonuri" + "<br>" + "masa" + "</center></html>");
				bonuriMasaTitular.setFont(font);
				solicitant.add(bonuriMasaTitular);
				
				inputBonuriMasaTitular = new JTextField(3);
				solicitant.add(inputBonuriMasaTitular);
				
				marireTitular = new JCheckBox("Marire cu peste 20% justificata");
				marireTitular.setFont(font);
				solicitant.add(marireTitular);
				
				contractMuncaTitular = new JLabel("<html><center>" + "Contract" + "<br>" + "munca" + "</center></html>");
				contractMuncaTitular.setFont(font);
				solicitant.add(contractMuncaTitular);
				
				inputContractMuncaTitular = new JComboBox<String>(contractType);
				solicitant.add(inputContractMuncaTitular);
				
				dataExpirareContractTitular = new JLabel("<html><center>" + "Data" + "<br>" + "expirare" + "</center></html>");
				dataExpirareContractTitular.setFont(font);
				solicitant.add(dataExpirareContractTitular);
				
				inputDataExpirareContractTitular = new JTextField(8);
				solicitant.add(inputDataExpirareContractTitular);
				
				// row16
				conventieSalarialaTitular = new JCheckBox("Conventie Salariala");
				conventieSalarialaTitular.setFont(font);
				conventieSalarialaTitular.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent actionEvent)
					{
						JCheckBox temp = (JCheckBox)actionEvent.getSource();
						if(temp.isSelected())
						{
							inputBancaConventieTitular.setEnabled(true);
							inputBancaConventieTitular.setBackground(Color.WHITE);
						}	
						
						if(!temp.isSelected())
						{
							inputBancaConventieTitular.setEnabled(false);
							inputBancaConventieTitular.setBackground(Color.LIGHT_GRAY);
						}
					}
				});
				solicitant.add(conventieSalarialaTitular);
				
				inputBancaConventieTitular = new JTextField(10);
				inputBancaConventieTitular.setEnabled(false);
				inputBancaConventieTitular.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputBancaConventieTitular);
				
				conturiBanciTitular = new JLabel("<html><center>" + "Conturi la" + "<br>" + "alte banci" + "</center></html>");
				conturiBanciTitular.setFont(font);
				solicitant.add(conturiBanciTitular);
				
				inputConturiBanciTitular = new JTextField(22);
				solicitant.add(inputConturiBanciTitular);
				
				istoricCreditareTitular = new JCheckBox("Istoric Creditare");
				istoricCreditareTitular.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent actionEvent)
					{
						JCheckBox temp = (JCheckBox)actionEvent.getSource();
						if(temp.isSelected())
						{
							// row20
							inputTipCreditTitular1.setEnabled(true);
							inputTipCreditTitular1.setBackground(Color.WHITE);
														
							inputCreditorTitular1.setEnabled(true);
							inputCreditorTitular1.setBackground(Color.WHITE);
																			
							inputSumaInitialaTitular1.setEnabled(true);
							inputSumaInitialaTitular1.setBackground(Color.WHITE);
							
							inputRataLunaraTitular1.setEnabled(true);
							inputRataLunaraTitular1.setBackground(Color.WHITE);
														
							inputSoldCreditTitular1.setEnabled(true);
							inputSoldCreditTitular1.setBackground(Color.WHITE);
														
							inputDataContractareTitular1.setEnabled(true);
							inputDataContractareTitular1.setBackground(Color.WHITE);
							
							inputScadentaTitular1.setEnabled(true);
							inputScadentaTitular1.setBackground(Color.WHITE);
							
							refinanteazaTitular1.setEnabled(true);
							intarzieriTitular1.setEnabled(true);
							inchideTitular1.setEnabled(true);
						
							// row21
							inputTipCreditTitular2.setEnabled(true);
							inputTipCreditTitular2.setBackground(Color.WHITE);

							inputCreditorTitular2.setEnabled(true);
							inputCreditorTitular2.setBackground(Color.WHITE);

							inputSumaInitialaTitular2.setEnabled(true);
							inputSumaInitialaTitular2.setBackground(Color.WHITE);

							inputRataLunaraTitular2.setEnabled(true);
							inputRataLunaraTitular2.setBackground(Color.WHITE);

							inputSoldCreditTitular2.setEnabled(true);
							inputSoldCreditTitular2.setBackground(Color.WHITE);

							inputDataContractareTitular2.setEnabled(true);
							inputDataContractareTitular2.setBackground(Color.WHITE);

							inputScadentaTitular2.setEnabled(true);
							inputScadentaTitular2.setBackground(Color.WHITE);

							refinanteazaTitular2.setEnabled(true);
							intarzieriTitular2.setEnabled(true);
							inchideTitular2.setEnabled(true);
							
							// row22

							inputTipCreditTitular3.setEnabled(true);
							inputTipCreditTitular3.setBackground(Color.WHITE);
	
							inputCreditorTitular3.setEnabled(true);
							inputCreditorTitular3.setBackground(Color.WHITE);
	
							inputSumaInitialaTitular3.setEnabled(true);
							inputSumaInitialaTitular3.setBackground(Color.WHITE);
	
							inputRataLunaraTitular3.setEnabled(true);
							inputRataLunaraTitular3.setBackground(Color.WHITE);
	
							inputSoldCreditTitular3.setEnabled(true);
							inputSoldCreditTitular3.setBackground(Color.WHITE);
	
							inputDataContractareTitular3.setEnabled(true);
							inputDataContractareTitular3.setBackground(Color.WHITE);
	
							inputScadentaTitular3.setEnabled(true);
							inputScadentaTitular3.setBackground(Color.WHITE);

							refinanteazaTitular3.setEnabled(true);
							intarzieriTitular3.setEnabled(true);
							inchideTitular3.setEnabled(true);
								
							// row23
							inputTipCreditTitular4.setEnabled(true);
							inputTipCreditTitular4.setBackground(Color.WHITE);
	
							inputCreditorTitular4.setEnabled(true);
							inputCreditorTitular4.setBackground(Color.WHITE);
	
							inputSumaInitialaTitular4.setEnabled(true);
							inputSumaInitialaTitular4.setBackground(Color.WHITE);
	
							inputRataLunaraTitular4.setEnabled(true);
							inputRataLunaraTitular4.setBackground(Color.WHITE);
	
							inputSoldCreditTitular4.setEnabled(true);
							inputSoldCreditTitular4.setBackground(Color.WHITE);
	
							inputDataContractareTitular4.setEnabled(true);
							inputDataContractareTitular4.setBackground(Color.WHITE);
		
							inputScadentaTitular4.setEnabled(true);
							inputScadentaTitular4.setBackground(Color.WHITE);
	
							refinanteazaTitular4.setEnabled(true);
							intarzieriTitular4.setEnabled(true);
							inchideTitular4.setEnabled(true);
						}	
						
						if(!temp.isSelected())
						{
							// row20
							inputTipCreditTitular1.setEnabled(false);
							inputTipCreditTitular1.setBackground(Color.LIGHT_GRAY);
														
							inputCreditorTitular1.setEnabled(false);
							inputCreditorTitular1.setBackground(Color.LIGHT_GRAY);
																			
							inputSumaInitialaTitular1.setEnabled(false);
							inputSumaInitialaTitular1.setBackground(Color.LIGHT_GRAY);
							
							inputRataLunaraTitular1.setEnabled(false);
							inputRataLunaraTitular1.setBackground(Color.LIGHT_GRAY);
														
							inputSoldCreditTitular1.setEnabled(false);
							inputSoldCreditTitular1.setBackground(Color.LIGHT_GRAY);
														
							inputDataContractareTitular1.setEnabled(false);
							inputDataContractareTitular1.setBackground(Color.LIGHT_GRAY);
							
							inputScadentaTitular1.setEnabled(false);
							inputScadentaTitular1.setBackground(Color.LIGHT_GRAY);
							
							refinanteazaTitular1.setEnabled(false);
							intarzieriTitular1.setEnabled(false);
							inchideTitular1.setEnabled(false);
						
							// row21
							inputTipCreditTitular2.setEnabled(false);
							inputTipCreditTitular2.setBackground(Color.LIGHT_GRAY);

							inputCreditorTitular2.setEnabled(false);
							inputCreditorTitular2.setBackground(Color.LIGHT_GRAY);

							inputSumaInitialaTitular2.setEnabled(false);
							inputSumaInitialaTitular2.setBackground(Color.LIGHT_GRAY);

							inputRataLunaraTitular2.setEnabled(false);
							inputRataLunaraTitular2.setBackground(Color.LIGHT_GRAY);

							inputSoldCreditTitular2.setEnabled(false);
							inputSoldCreditTitular2.setBackground(Color.LIGHT_GRAY);

							inputDataContractareTitular2.setEnabled(false);
							inputDataContractareTitular2.setBackground(Color.LIGHT_GRAY);

							inputScadentaTitular2.setEnabled(false);
							inputScadentaTitular2.setBackground(Color.LIGHT_GRAY);

							refinanteazaTitular2.setEnabled(false);
							intarzieriTitular2.setEnabled(false);
							inchideTitular2.setEnabled(false);
							
							// row22

							inputTipCreditTitular3.setEnabled(false);
							inputTipCreditTitular3.setBackground(Color.LIGHT_GRAY);
	
							inputCreditorTitular3.setEnabled(false);
							inputCreditorTitular3.setBackground(Color.LIGHT_GRAY);
	
							inputSumaInitialaTitular3.setEnabled(false);
							inputSumaInitialaTitular3.setBackground(Color.LIGHT_GRAY);
	
							inputRataLunaraTitular3.setEnabled(false);
							inputRataLunaraTitular3.setBackground(Color.LIGHT_GRAY);
	
							inputSoldCreditTitular3.setEnabled(false);
							inputSoldCreditTitular3.setBackground(Color.LIGHT_GRAY);
	
							inputDataContractareTitular3.setEnabled(false);
							inputDataContractareTitular3.setBackground(Color.LIGHT_GRAY);
	
							inputScadentaTitular3.setEnabled(false);
							inputScadentaTitular3.setBackground(Color.LIGHT_GRAY);

							refinanteazaTitular3.setEnabled(false);
							intarzieriTitular3.setEnabled(false);
							inchideTitular3.setEnabled(false);
								
							// row23
							inputTipCreditTitular4.setEnabled(false);
							inputTipCreditTitular4.setBackground(Color.LIGHT_GRAY);
	
							inputCreditorTitular4.setEnabled(false);
							inputCreditorTitular4.setBackground(Color.LIGHT_GRAY);
	
							inputSumaInitialaTitular4.setEnabled(false);
							inputSumaInitialaTitular4.setBackground(Color.LIGHT_GRAY);
	
							inputRataLunaraTitular4.setEnabled(false);
							inputRataLunaraTitular4.setBackground(Color.LIGHT_GRAY);
	
							inputSoldCreditTitular4.setEnabled(false);
							inputSoldCreditTitular4.setBackground(Color.LIGHT_GRAY);
	
							inputDataContractareTitular4.setEnabled(false);
							inputDataContractareTitular4.setBackground(Color.LIGHT_GRAY);
		
							inputScadentaTitular4.setEnabled(false);
							inputScadentaTitular4.setBackground(Color.LIGHT_GRAY);
	
							refinanteazaTitular4.setEnabled(false);
							intarzieriTitular4.setEnabled(false);
							inchideTitular4.setEnabled(false);
						}
					}
				});
				
				istoricCreditareTitular.setFont(font);
				solicitant.add(istoricCreditareTitular);
				
				// row17
				numarImobileTitular = new JLabel("Nr. imobile");
				numarImobileTitular.setFont(font);
				solicitant.add(numarImobileTitular);
				
				inputNumarImobileTitular = new JTextField(2);
				solicitant.add(inputNumarImobileTitular);
				
				PADTitular = new JLabel("PAD");
				PADTitular.setFont(font);
				solicitant.add(PADTitular);
				
				inputPADTitular = new JTextField(3);
				solicitant.add(inputPADTitular);
				
				asigurareTitular = new JLabel("Asigurare");
				asigurareTitular.setFont(font);
				solicitant.add(asigurareTitular);
				
				inputAsigurareTitular = new JTextField(3);
				solicitant.add(inputAsigurareTitular);
				
				impozitTitular = new JLabel("Impozit");
				impozitTitular.setFont(font);
				solicitant.add(impozitTitular);
				
				inputImpozitTitular = new JTextField(3);
				solicitant.add(inputImpozitTitular);
				
				numarMasiniTitular = new JLabel("Nr. masini");
				numarMasiniTitular.setFont(font);
				solicitant.add(numarMasiniTitular);
				
				inputNumarMasiniTitular = new JTextField(2);
				solicitant.add(inputNumarMasiniTitular);
				
				RCATitular = new JLabel("RCA");
				RCATitular.setFont(font);
				solicitant.add(RCATitular);
				
				inputRCATitular = new JTextField(3);
				solicitant.add(inputRCATitular);
								
				cascoTitular = new JLabel("Casco");
				cascoTitular.setFont(font);
				solicitant.add(cascoTitular);
				
				inputCascoTitular = new JTextField(3);
				solicitant.add(inputCascoTitular);
				
				impozitMasinaTitular = new JLabel("Impozit");
				impozitMasinaTitular.setFont(font);
				solicitant.add(impozitMasinaTitular);
				
				inputImpozitMasinaTitular = new JTextField(3);
				solicitant.add(inputImpozitMasinaTitular);
				
				
				// row18
				numarMembriFamilieTitular = new JLabel("<html><center>" + "Nr. membri" + "<br>" + "familie" + "</center></html>");
				numarMembriFamilieTitular.setFont(font);
				solicitant.add(numarMembriFamilieTitular);
				
				inputNumarMembriFamilieTitular = new JTextField(2);
				solicitant.add(inputNumarMembriFamilieTitular);
				
				numarCopiiTitular = new JLabel("<html><center>" + "Nr. copii" + "<br>" + "intretinere" + "</center></html>");
				numarCopiiTitular.setFont(font);
				solicitant.add(numarCopiiTitular);
				
				inputNumarCopiiTitular = new JTextField(2);
				solicitant.add(inputNumarCopiiTitular);
				
				numarPersoaneIntretinereTitular = new JLabel("<html><center>" + "Nr. persoane" + "<br>" + "intretinere" + "</center></html>");
				numarPersoaneIntretinereTitular.setFont(font);
				solicitant.add(numarPersoaneIntretinereTitular);
				
				inputNumarPersoaneIntretinereTitular = new JTextField(2);
				solicitant.add(inputNumarPersoaneIntretinereTitular);
				
				inputSituatieFamilialaTitular = new JComboBox<String>(situatieFamilialaType);
				solicitant.add(inputSituatieFamilialaTitular);
				// padding for row18
				JTextField padding1 = new JTextField(23);
				padding1.setEnabled(false);
				padding1.setBackground(this.getBackground());
				padding1.setBorder(null);
				solicitant.add(padding1);
				
				// row19
				tipCreditTitular = new JLabel(String.format("%-7s"," Tip "));
				tipCreditTitular.setFont(font);
				solicitant.add(tipCreditTitular);
				
				creditorTitular = new JLabel(String.format("%-24s", "Creditor"));
				creditorTitular.setFont(font);
				solicitant.add(creditorTitular);
				
				sumaInitialaTitular = new JLabel("Suma initiala");
				sumaInitialaTitular.setFont(font);
				solicitant.add(sumaInitialaTitular);
				
				rataLunaraTitular = new JLabel("Rata lunar");
				rataLunaraTitular.setFont(font);
				solicitant.add(rataLunaraTitular);
				
				soldCreditTitular = new JLabel(String.format("%-18s", "Sold credit"));
				soldCreditTitular.setFont(font);
				solicitant.add(soldCreditTitular);
				
				dataContractareTitular = new JLabel("<html><center>" + "Data" + "<br>" + "contract" + "</center></html>");
				dataContractareTitular.setFont(font);
				solicitant.add(dataContractareTitular);
				
				scadentaTitular = new JLabel("     Scadenta");
				scadentaTitular.setFont(font);
				solicitant.add(scadentaTitular);
				// padding for row19
				JTextField padding2 = new JTextField(21);
				padding2.setEnabled(false);
				padding2.setBackground(this.getBackground());
				padding2.setBorder(null);
				solicitant.add(padding2);
				
				// row20
				inputTipCreditTitular1 = new JTextField(2);
				inputTipCreditTitular1.setEnabled(false);
				inputTipCreditTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputTipCreditTitular1);
				
				inputCreditorTitular1 = new JTextField(7);
				inputCreditorTitular1.setEnabled(false);
				inputCreditorTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputCreditorTitular1);
				
				inputSumaInitialaTitular1 = new JTextField(5);
				inputSumaInitialaTitular1.setEnabled(false);
				inputSumaInitialaTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSumaInitialaTitular1);

				inputRataLunaraTitular1 = new JTextField(3);
				inputRataLunaraTitular1.setEnabled(false);
				inputRataLunaraTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputRataLunaraTitular1);
				
				inputSoldCreditTitular1 = new JTextField(5);
				inputSoldCreditTitular1.setEnabled(false);
				inputSoldCreditTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSoldCreditTitular1);
				
				inputDataContractareTitular1 = new JTextField(4);
				inputDataContractareTitular1.setEnabled(false);
				inputDataContractareTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputDataContractareTitular1);
				
				inputScadentaTitular1 = new JTextField(4);
				inputScadentaTitular1.setEnabled(false);
				inputScadentaTitular1.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputScadentaTitular1);
				
				refinanteazaTitular1 = new JCheckBox("Refinantare?");
				refinanteazaTitular1.setEnabled(false);
				refinanteazaTitular1.setFont(font);
				solicitant.add(refinanteazaTitular1);
				
				intarzieriTitular1 = new JCheckBox("Intarzieri?");
				intarzieriTitular1.setEnabled(false);
				intarzieriTitular1.setFont(font);
				solicitant.add(intarzieriTitular1);
				
				inchideTitular1 = new JCheckBox("Se inchide?");
				inchideTitular1.setEnabled(false);
				inchideTitular1.setFont(font);
				solicitant.add(inchideTitular1);
				
				// row21
				inputTipCreditTitular2 = new JTextField(2);
				inputTipCreditTitular2.setEnabled(false);
				inputTipCreditTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputTipCreditTitular2);
				
				inputCreditorTitular2 = new JTextField(7);
				inputCreditorTitular2.setEnabled(false);
				inputCreditorTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputCreditorTitular2);
				
				inputSumaInitialaTitular2 = new JTextField(5);
				inputSumaInitialaTitular2.setEnabled(false);
				inputSumaInitialaTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSumaInitialaTitular2);

				inputRataLunaraTitular2 = new JTextField(3);
				inputRataLunaraTitular2.setEnabled(false);
				inputRataLunaraTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputRataLunaraTitular2);
				
				inputSoldCreditTitular2 = new JTextField(5);
				inputSoldCreditTitular2.setEnabled(false);
				inputSoldCreditTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSoldCreditTitular2);
				
				inputDataContractareTitular2 = new JTextField(4);
				inputDataContractareTitular2.setEnabled(false);
				inputDataContractareTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputDataContractareTitular2);
				
				inputScadentaTitular2 = new JTextField(4);
				inputScadentaTitular2.setEnabled(false);
				inputScadentaTitular2.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputScadentaTitular2);
				
				refinanteazaTitular2 = new JCheckBox("Refinantare?");
				refinanteazaTitular2.setEnabled(false);
				refinanteazaTitular2.setFont(font);
				solicitant.add(refinanteazaTitular2);
				
				intarzieriTitular2 = new JCheckBox("Intarzieri?");
				intarzieriTitular2.setEnabled(false);
				intarzieriTitular2.setFont(font);
				solicitant.add(intarzieriTitular2);
				
				inchideTitular2 = new JCheckBox("Se inchide?");
				inchideTitular2.setEnabled(false);
				inchideTitular2.setFont(font);
				solicitant.add(inchideTitular2);
				
				// row22
				inputTipCreditTitular3 = new JTextField(2);
				inputTipCreditTitular3.setEnabled(false);
				inputTipCreditTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputTipCreditTitular3);
				
				inputCreditorTitular3 = new JTextField(7);
				inputCreditorTitular3.setEnabled(false);
				inputCreditorTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputCreditorTitular3);
				
				inputSumaInitialaTitular3 = new JTextField(5);
				inputSumaInitialaTitular3.setEnabled(false);
				inputSumaInitialaTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSumaInitialaTitular3);

				inputRataLunaraTitular3 = new JTextField(3);
				inputRataLunaraTitular3.setEnabled(false);
				inputRataLunaraTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputRataLunaraTitular3);
				
				inputSoldCreditTitular3 = new JTextField(5);
				inputSoldCreditTitular3.setEnabled(false);
				inputSoldCreditTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSoldCreditTitular3);
				
				inputDataContractareTitular3 = new JTextField(4);
				inputDataContractareTitular3.setEnabled(false);
				inputDataContractareTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputDataContractareTitular3);
				
				inputScadentaTitular3 = new JTextField(4);
				inputScadentaTitular3.setEnabled(false);
				inputScadentaTitular3.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputScadentaTitular3);
				
				refinanteazaTitular3 = new JCheckBox("Refinantare?");
				refinanteazaTitular3.setEnabled(false);
				refinanteazaTitular3.setFont(font);
				solicitant.add(refinanteazaTitular3);
				
				intarzieriTitular3 = new JCheckBox("Intarzieri?");
				intarzieriTitular3.setEnabled(false);
				intarzieriTitular3.setFont(font);
				solicitant.add(intarzieriTitular3);
				
				inchideTitular3 = new JCheckBox("Se inchide?");
				inchideTitular3.setEnabled(false);
				inchideTitular3.setFont(font);
				solicitant.add(inchideTitular3);
				
				// row23
				inputTipCreditTitular4 = new JTextField(2);
				inputTipCreditTitular4.setEnabled(false);
				inputTipCreditTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputTipCreditTitular4);
				
				inputCreditorTitular4 = new JTextField(7);
				inputCreditorTitular4.setEnabled(false);
				inputCreditorTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputCreditorTitular4);
				
				inputSumaInitialaTitular4 = new JTextField(5);
				inputSumaInitialaTitular4.setEnabled(false);
				inputSumaInitialaTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSumaInitialaTitular4);

				inputRataLunaraTitular4 = new JTextField(3);
				inputRataLunaraTitular4.setEnabled(false);
				inputRataLunaraTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputRataLunaraTitular4);
				
				inputSoldCreditTitular4 = new JTextField(5);
				inputSoldCreditTitular4.setEnabled(false);
				inputSoldCreditTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputSoldCreditTitular4);
				
				inputDataContractareTitular4 = new JTextField(4);
				inputDataContractareTitular4.setEnabled(false);
				inputDataContractareTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputDataContractareTitular4);
				
				inputScadentaTitular4 = new JTextField(4);
				inputScadentaTitular4.setEnabled(false);
				inputScadentaTitular4.setBackground(Color.LIGHT_GRAY);
				solicitant.add(inputScadentaTitular4);
				
				refinanteazaTitular4 = new JCheckBox("Refinantare?");
				refinanteazaTitular4.setEnabled(false);
				refinanteazaTitular4.setFont(font);
				solicitant.add(refinanteazaTitular4);
				
				intarzieriTitular4 = new JCheckBox("Intarzieri?");
				intarzieriTitular4.setEnabled(false);
				intarzieriTitular4.setFont(font);
				solicitant.add(intarzieriTitular4);
				
				inchideTitular4 = new JCheckBox("Se inchide?");
				inchideTitular4.setEnabled(false);
				inchideTitular4.setFont(font);
				solicitant.add(inchideTitular4);
		
				
		tabbedPane.addTab("Solicitant",null, solicitant, "Info solicitant");
			
		codebitor = new JPanel();
		codebitor.setLayout(flow);
		
			//row1
			numeCodebitor = new JLabel("Nume");
			numeCodebitor.setFont(font);
			codebitor.add(numeCodebitor);
							
			inputNumeCodebitor = new JTextField(10);
			codebitor.add(inputNumeCodebitor);
						
			prenumeCodebitor = new JLabel("Prenume");
			prenumeCodebitor.setFont(font);
			codebitor.add(prenumeCodebitor);
							
			inputPrenumeCodebitor = new JTextField(10);
			codebitor.add(inputPrenumeCodebitor);
							
			numeMamaCodebitor = new JLabel("<html><center>" + "Nume" + "<br>" + "mama" + "</center></html>");
			numeMamaCodebitor.setFont(font);
			codebitor.add(numeMamaCodebitor);
				
			inputNumeMamaCodebitor = new JTextField(10);
			codebitor.add(inputNumeMamaCodebitor);
							
			prenumeTataCodebitor = new JLabel("<html><center>" + "Prenume" + "<br>" + "tata" + "</center></html>");
			prenumeTataCodebitor.setFont(font);
			codebitor.add(prenumeTataCodebitor);
						
			inputPrenumeTataCodebitor = new JTextField(10);
			codebitor.add(inputPrenumeTataCodebitor);
			
			//row2
			dataNastereCodebitor = new JLabel("<html><center>" + "Data" + "<br>" + "nastere" + "</center></html>");
			dataNastereCodebitor.setFont(font);
			codebitor.add(dataNastereCodebitor);
						
			inputDataNastereCodebitor = new JTextField(6);
			codebitor.add(inputDataNastereCodebitor);
						
			localitateNastereCodebitor = new JLabel("<html><center>" + "Localitate" + "<br>" + "nastere" + "</center></html>");
			localitateNastereCodebitor.setFont(font);
			codebitor.add(localitateNastereCodebitor);
						
			inputLocalitateNastereCodebitor = new JTextField(10);
			codebitor.add(inputLocalitateNastereCodebitor);
						
			IDCodebitor = new JComboBox<String>(IDType);
			codebitor.add(IDCodebitor);
						
			inputIDCodebitor = new JTextField(6);
			codebitor.add(inputIDCodebitor);
							
			dataEliberareCodebitor = new JLabel("<html><center>" + "Data" + "<br>" + "eliberare" + "</center></html>");
			dataEliberareCodebitor.setFont(font);
			codebitor.add(dataEliberareCodebitor);
						
			inputDataEliberareCodebitor = new JTextField(6);
			codebitor.add(inputDataEliberareCodebitor);
						
			vechimeAdresaCodebitor = new JLabel("<html><center>" + "Vechime" + "<br>" + "adresa" + "</center></html>");
			vechimeAdresaCodebitor.setFont(font);
			codebitor.add(vechimeAdresaCodebitor);
					
			inputVechimeAdresaCodebitor = new JTextField(6);
			codebitor.add(inputVechimeAdresaCodebitor);
		
			// row3
			CNPCodebitor = new JLabel("CNP");
			CNPCodebitor.setFont(font);
			codebitor.add(CNPCodebitor);
					
			inputCNPCodebitor = new JTextField(11);
			codebitor.add(inputCNPCodebitor);
					
			CNPSotCodebitor = new JLabel("<html><center>" + "CNP" + "<br>" + "sot/sotie" + "</center></html>");
			CNPSotCodebitor.setFont(font);
			codebitor.add(CNPSotCodebitor);
					
			inputCNPSotCodebitor = new JTextField(11);
			codebitor.add(inputCNPSotCodebitor);
					
			eliberatDeCodebitor = new JLabel("<html><center>" + "elib." + "<br>" + "de" + "</center></html>");
			eliberatDeCodebitor.setFont(font);
			codebitor.add(eliberatDeCodebitor);
					
			inputEliberatDeCodebitor = new JTextField(11);
			codebitor.add(inputEliberatDeCodebitor);
					
			valabilPanaDataCodebitor = new JLabel("<html><center>" + "data" + "<br>" + "valab" + "</center></html>");
			valabilPanaDataCodebitor.setFont(font);
			codebitor.add(valabilPanaDataCodebitor);
						
			inputValabilPanaDataCodebitor = new JTextField(10);
			codebitor.add(inputValabilPanaDataCodebitor);
				
			// row4
			adresaCodebitor = new JLabel("Adresa");
			adresaCodebitor.setFont(font);
			codebitor.add(adresaCodebitor);
					
			inputAdresaCodebitor = new JTextField(52);
			codebitor.add(inputAdresaCodebitor);
					
			// row5
			resedintaCodebitor = new JLabel("Resedinta");
			resedintaCodebitor.setFont(font);
			codebitor.add(resedintaCodebitor);
					
			inputResedintaCodebitor = new JTextField(32);
			codebitor.add(inputResedintaCodebitor);
			
			numeSotCodebitor = new JLabel("<html><center>" + "Nume" + "<br>" + "sot/sotie" + "</center></html>");
			numeSotCodebitor.setFont(font);
			codebitor.add(numeSotCodebitor);
					
			inputNumeSotCodebitor = new JTextField(15);
			codebitor.add(inputNumeSotCodebitor);
			
			// row6
			fixCodebitor = new JLabel("Fix");
			fixCodebitor.setFont(font);
			codebitor.add(fixCodebitor);
					
			inputFixCodebitor = new JTextField(9);
			codebitor.add(inputFixCodebitor);
							
			mobilCodebitor = new JLabel("Mobil");
			mobilCodebitor.setFont(font);
			codebitor.add(mobilCodebitor);
					
			inputMobilCodebitor = new JTextField(9);
			codebitor.add(inputMobilCodebitor);
			
			inputAbonamentCodebitor = new JComboBox<String>(abonamentType);
			codebitor.add(inputAbonamentCodebitor);
			
			emailCodebitor = new JLabel("Email");
			emailCodebitor.setFont(font);
			codebitor.add(emailCodebitor);
			
			inputEmailCodebitor = new JTextField(14);
			codebitor.add(inputEmailCodebitor);
			
			masinaCodebitor = new JCheckBox("Masina");
			masinaCodebitor.setFont(font);
			codebitor.add(masinaCodebitor);
			
			// row7
			studiiCodebitor = new JLabel("Studii");
			studiiCodebitor.setFont(font);
			codebitor.add(studiiCodebitor);
			
			inputStudiiCodebitor = new JComboBox<String>(studiiType);
			codebitor.add(inputStudiiCodebitor);
			
			situatieLocativaCodebitor = new JLabel("<html><center>" + "Situatie" + "<br>" + "locativa" + "</center></html>");
			situatieLocativaCodebitor.setFont(font);
			codebitor.add(situatieLocativaCodebitor);
			
			inputSituatieLocativaCodebitor = new JComboBox<String>(situatieLocativaType);
			codebitor.add(inputSituatieLocativaCodebitor);
			
			tipImobilCodebitor = new JLabel("<html><center>" + "Tip" + "<br>" + "imobil" + "</center></html>");
			tipImobilCodebitor.setFont(font);
			codebitor.add(tipImobilCodebitor);
			
			inputTipImobilCodebitor = new JComboBox<String>(tipImobilType);
			codebitor.add(inputTipImobilCodebitor);
			
			// row8
			angajatorCodebitor = new JLabel("Angajator");
			angajatorCodebitor.setFont(font);
			codebitor.add(angajatorCodebitor);
			
			inputAngajatorCodebitor = new JTextField(14);
			codebitor.add(inputAngajatorCodebitor);
			
			CUICodebitor = new JLabel("CUI");
			CUICodebitor.setFont(font);
			codebitor.add(CUICodebitor);
			
			inputCUICodebitor = new JTextField(5);
			codebitor.add(inputCUICodebitor);
			
			nrAngajatiCodebitor = new JLabel("<html><center>" + "Nr" + "<br>" + "angajati" + "</center></html>");
			nrAngajatiCodebitor.setFont(font);
			codebitor.add(nrAngajatiCodebitor);
			
			inputNrAngajatiCodebitor = new JTextField(3);
			codebitor.add(inputNrAngajatiCodebitor);
			
			dataInfiintareCodebitor = new JLabel("<html><center>" + "Data" + "<br>" + "infiintare" + "</center></html>");
			dataInfiintareCodebitor.setFont(font);
			codebitor.add(dataInfiintareCodebitor);
			
			inputDataInfiintareCodebitor = new JTextField(6);
			codebitor.add(inputDataInfiintareCodebitor);
			
			telAngajatorCodebitor = new JLabel("<html><center>" + "Telefon" + "<br>" + "fix" + "</center></html>");
			telAngajatorCodebitor.setFont(font);
			codebitor.add(telAngajatorCodebitor);
			
			inputTelAngajatorCodebitor = new JTextField(8);
			codebitor.add(inputTelAngajatorCodebitor);
			
			// row9
			adresaAngajatorCodebitor = new JLabel("Adresa");
			adresaAngajatorCodebitor.setFont(font);
			codebitor.add(adresaAngajatorCodebitor);
			
			inputAdresaAngajatorCodebitor = new JTextField(23);
			codebitor.add(inputAdresaAngajatorCodebitor);
			
			dataAngajareCodebitor = new JLabel("<html><center>" + "Data" + "<br>" + "Angajare" + "</center></html>");
			dataAngajareCodebitor.setFont(font);
			codebitor.add(dataAngajareCodebitor);
			
			inputDataAngajareCodebitor = new JTextField(6);
			codebitor.add(inputDataAngajareCodebitor);
			
			vechimeTotalaCodebitor = new JLabel("<html><center>" + "Vechime" + "<br>" + "totala (luni)" + "</center></html>");
			vechimeTotalaCodebitor.setFont(font);
			codebitor.add(vechimeTotalaCodebitor);
			
			inputVechimeTotalaCodebitor = new JTextField(3);
			codebitor.add(inputVechimeTotalaCodebitor);
			
			vechimeUltimAngajatorCodebitor = new JLabel("<html><center>" + "Vechime" + "<br>" + "ultim angajator" + "</center></html>");
			vechimeUltimAngajatorCodebitor.setFont(font);
			codebitor.add(vechimeUltimAngajatorCodebitor);
			
			inputVechimeUltimAngajatorCodebitor = new JTextField(3);
			codebitor.add(inputVechimeUltimAngajatorCodebitor);
			
			// row10
			capitalCodebitor = new JLabel("Capital");
			capitalCodebitor.setFont(font);
			codebitor.add(capitalCodebitor);
			
			inputCapitalCodebitor = new JComboBox<String>(capitalType);
			codebitor.add(inputCapitalCodebitor);
			
			tipSocietateCodebitor = new JLabel("<html><center>" + "Tip" + "<br>" + "societate" + "</center></html>");
			tipSocietateCodebitor.setFont(font);
			codebitor.add(tipSocietateCodebitor);
			
			inputTipSocietateCodebitor = new JComboBox<String>(societateType);
			codebitor.add(inputTipSocietateCodebitor);
			
			CAENCodebitor = new JLabel("<html><center>" + "Cod" + "<br>" + "CAEN" + "</center></html>");
			CAENCodebitor.setFont(font);
			codebitor.add(CAENCodebitor);
			
			inputCAENCodebitor = new JTextField(4);
			codebitor.add(inputCAENCodebitor);
			
			multinationalaCodebitor = new JCheckBox("Multinationala");
			multinationalaCodebitor.setFont(font);
			codebitor.add(multinationalaCodebitor);
			
			domeniuCodebitor = new JLabel("<html><center>" + "Domeniu" + "<br>" + "activitate" + "</center></html>");
			domeniuCodebitor.setFont(font);
			codebitor.add(domeniuCodebitor);
			
			inputDomeniuCodebitor = new JTextField(11);
			codebitor.add(inputDomeniuCodebitor);
			
			// row11
			tipFunctieCodebitor = new JLabel("Functie");
			tipFunctieCodebitor.setFont(font);
			codebitor.add(tipFunctieCodebitor);
			
			inputTipFunctieCodebitor = new JComboBox<String>(functieType);
			codebitor.add(inputTipFunctieCodebitor);
			
			functieCodebitor = new JLabel("<html><center>" + "Functie" + "<br>" + "actuala" + "</center></html>");
			functieCodebitor.setFont(font);
			codebitor.add(functieCodebitor);
			
			inputFunctieCodebitor = new JTextField(15);
			codebitor.add(inputFunctieCodebitor);
			
			profesieCodebitor = new JLabel("<html><center>" + "Profesie" + "<br>" + "cf. studii" + "</center></html>");
			profesieCodebitor.setFont(font);
			codebitor.add(profesieCodebitor);
			
			inputProfesieCodebitor = new JTextField(15);
			codebitor.add(inputProfesieCodebitor);
			
			// row12
			venitCurentCodebitor1 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an curent" + "</center></html>");
			venitCurentCodebitor1.setFont(font);
			codebitor.add(venitCurentCodebitor1);
			
			inputVenitCurentCodebitor1 = new JTextField(4);
			codebitor.add(inputVenitCurentCodebitor1);
			
			venitAnPrecedentCodebitor1 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an precedent" + "</center></html>");
			venitAnPrecedentCodebitor1.setFont(font);
			codebitor.add(venitAnPrecedentCodebitor1);
			
			inputVenitAnPrecedentCodebitor1 = new JTextField(4);
			codebitor.add(inputVenitAnPrecedentCodebitor1);
			
			inputTipVenitCodebitor1 = new JComboBox<String>(venitType);
			codebitor.add(inputTipVenitCodebitor1);
			
			alteVenituriCodebitor = new JLabel("Alte venituri aditionale salariului (neincluse la veniturile din tabel.)");
			alteVenituriCodebitor.setFont(font);
			codebitor.add(alteVenituriCodebitor);
			
			// row13
			venitCurentCodebitor2 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an curent" + "</center></html>");
			venitCurentCodebitor2.setFont(font);
			codebitor.add(venitCurentCodebitor2);
			
			inputVenitCurentCodebitor2 = new JTextField(4);
			codebitor.add(inputVenitCurentCodebitor2);
			
			venitAnPrecedentCodebitor2 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an precedent" + "</center></html>");
			venitAnPrecedentCodebitor2.setFont(font);
			codebitor.add(venitAnPrecedentCodebitor2);
			
			inputVenitAnPrecedentCodebitor2 = new JTextField(4);
			codebitor.add(inputVenitAnPrecedentCodebitor2);
			
			inputTipVenitCodebitor2 = new JComboBox<String>(venitType);
			codebitor.add(inputTipVenitCodebitor2);
			
			venit3LuniCodebitor = new JLabel("3 luni");
			venit3LuniCodebitor.setFont(font);
			codebitor.add(venit3LuniCodebitor);
			
			inputVenit3LuniCodebitor = new JTextField(5);
			codebitor.add(inputVenit3LuniCodebitor);
			
			venit6LuniCodebitor = new JLabel("6 luni");
			venit6LuniCodebitor.setFont(font);
			codebitor.add(venit6LuniCodebitor);
			
			inputVenit6LuniCodebitor = new JTextField(5);
			codebitor.add(inputVenit6LuniCodebitor);
			
			venit12LuniCodebitor = new JLabel("12 luni");
			venit12LuniCodebitor.setFont(font);
			codebitor.add(venit12LuniCodebitor);
			
			inputVenit12LuniCodebitor = new JTextField(5);
			codebitor.add(inputVenit12LuniCodebitor);
			
			// row14
			venitCurentCodebitor3 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an curent" + "</center></html>");
			venitCurentCodebitor3.setFont(font);
			codebitor.add(venitCurentCodebitor3);
			
			inputVenitCurentCodebitor3 = new JTextField(4);
			codebitor.add(inputVenitCurentCodebitor3);
			
			venitAnPrecedentCodebitor3 = new JLabel("<html><center>" + "Venit net lunar" + "<br>" + "an precedent" + "</center></html>");
			venitAnPrecedentCodebitor3.setFont(font);
			codebitor.add(venitAnPrecedentCodebitor3);
			
			inputVenitAnPrecedentCodebitor3 = new JTextField(4);
			codebitor.add(inputVenitAnPrecedentCodebitor3);
			
			inputTipVenitCodebitor3 = new JComboBox<String>(venitType);
			codebitor.add(inputTipVenitCodebitor3);
			
			tipVenit3LuniCodebitor = new JLabel("   tip  ");
			tipVenit3LuniCodebitor.setFont(font);
			codebitor.add(tipVenit3LuniCodebitor);
			
			inputTipVenit3LuniCodebitor = new JTextField(5);
			codebitor.add(inputTipVenit3LuniCodebitor);
			
			tipVenit6LuniCodebitor = new JLabel("  tip  ");
			tipVenit6LuniCodebitor.setFont(font);
			codebitor.add(tipVenit6LuniCodebitor);
			
			inputTipVenit6LuniCodebitor = new JTextField(5);
			codebitor.add(inputTipVenit6LuniCodebitor);
			
			tipVenit12LuniCodebitor = new JLabel("   tip  ");
			tipVenit12LuniCodebitor.setFont(font);
			codebitor.add(tipVenit12LuniCodebitor);
			
			inputTipVenit12LuniCodebitor = new JTextField(5);
			codebitor.add(inputTipVenit12LuniCodebitor);
			
			// row15
			bonuriMasaCodebitor = new JLabel("<html><center>" + "Bonuri" + "<br>" + "masa" + "</center></html>");
			bonuriMasaCodebitor.setFont(font);
			codebitor.add(bonuriMasaCodebitor);
			
			inputBonuriMasaCodebitor = new JTextField(3);
			codebitor.add(inputBonuriMasaCodebitor);
			
			marireCodebitor = new JCheckBox("Marire cu peste 20% justificata");
			marireCodebitor.setFont(font);
			codebitor.add(marireCodebitor);
			
			contractMuncaCodebitor = new JLabel("<html><center>" + "Contract" + "<br>" + "munca" + "</center></html>");
			contractMuncaCodebitor.setFont(font);
			codebitor.add(contractMuncaCodebitor);
			
			inputContractMuncaCodebitor = new JComboBox<String>(contractType);
			codebitor.add(inputContractMuncaCodebitor);
			
			dataExpirareContractCodebitor = new JLabel("<html><center>" + "Data" + "<br>" + "expirare" + "</center></html>");
			dataExpirareContractCodebitor.setFont(font);
			codebitor.add(dataExpirareContractCodebitor);
			
			inputDataExpirareContractCodebitor = new JTextField(8);
			codebitor.add(inputDataExpirareContractCodebitor);
			
			// row16
			conventieSalarialaCodebitor = new JCheckBox("Conventie Salariala");
			conventieSalarialaCodebitor.setFont(font);
			conventieSalarialaCodebitor.addActionListener(new ActionListener()
										{
											@Override
											public void actionPerformed(ActionEvent actionEvent)
											{
												JCheckBox temp = (JCheckBox)actionEvent.getSource();
												if(temp.isSelected())
													{
													inputBancaConventieCodebitor.setEnabled(true);
													inputBancaConventieCodebitor.setBackground(Color.WHITE);
													}
												
												if(!temp.isSelected())
													{
													inputBancaConventieCodebitor.setEnabled(false);
													inputBancaConventieCodebitor.setBackground(Color.LIGHT_GRAY);
													}
											}
										});
			codebitor.add(conventieSalarialaCodebitor);
			
			inputBancaConventieCodebitor = new JTextField(10);
			inputBancaConventieCodebitor.setBackground(Color.LIGHT_GRAY);
			inputBancaConventieCodebitor.setEnabled(false);
			codebitor.add(inputBancaConventieCodebitor);
			
			conturiBanciCodebitor = new JLabel("<html><center>" + "Conturi la" + "<br>" + "alte banci" + "</center></html>");
			conturiBanciCodebitor.setFont(font);
			codebitor.add(conturiBanciCodebitor);
			
			inputConturiBanciCodebitor = new JTextField(22);
			codebitor.add(inputConturiBanciCodebitor);
			
			istoricCreditareCodebitor = new JCheckBox("Istoric Creditare");
			istoricCreditareCodebitor.setFont(font);
			istoricCreditareCodebitor.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent actionEvent)
				{
					JCheckBox temp = (JCheckBox)actionEvent.getSource();
					if(temp.isSelected())
					{
						// row20
						inputTipCreditCodebitor1.setEnabled(true);
						inputTipCreditCodebitor1.setBackground(Color.WHITE);
													
						inputCreditorCodebitor1.setEnabled(true);
						inputCreditorCodebitor1.setBackground(Color.WHITE);
																		
						inputSumaInitialaCodebitor1.setEnabled(true);
						inputSumaInitialaCodebitor1.setBackground(Color.WHITE);
						
						inputRataLunaraCodebitor1.setEnabled(true);
						inputRataLunaraCodebitor1.setBackground(Color.WHITE);
													
						inputSoldCreditCodebitor1.setEnabled(true);
						inputSoldCreditCodebitor1.setBackground(Color.WHITE);
													
						inputDataContractareCodebitor1.setEnabled(true);
						inputDataContractareCodebitor1.setBackground(Color.WHITE);
						
						inputScadentaCodebitor1.setEnabled(true);
						inputScadentaCodebitor1.setBackground(Color.WHITE);
						
						refinanteazaCodebitor1.setEnabled(true);
						intarzieriCodebitor1.setEnabled(true);
						inchideCodebitor1.setEnabled(true);
					
						// row21
						inputTipCreditCodebitor2.setEnabled(true);
						inputTipCreditCodebitor2.setBackground(Color.WHITE);

						inputCreditorCodebitor2.setEnabled(true);
						inputCreditorCodebitor2.setBackground(Color.WHITE);

						inputSumaInitialaCodebitor2.setEnabled(true);
						inputSumaInitialaCodebitor2.setBackground(Color.WHITE);

						inputRataLunaraCodebitor2.setEnabled(true);
						inputRataLunaraCodebitor2.setBackground(Color.WHITE);

						inputSoldCreditCodebitor2.setEnabled(true);
						inputSoldCreditCodebitor2.setBackground(Color.WHITE);

						inputDataContractareCodebitor2.setEnabled(true);
						inputDataContractareCodebitor2.setBackground(Color.WHITE);

						inputScadentaCodebitor2.setEnabled(true);
						inputScadentaCodebitor2.setBackground(Color.WHITE);

						refinanteazaCodebitor2.setEnabled(true);
						intarzieriCodebitor2.setEnabled(true);
						inchideCodebitor2.setEnabled(true);
						
						// row22

						inputTipCreditCodebitor3.setEnabled(true);
						inputTipCreditCodebitor3.setBackground(Color.WHITE);

						inputCreditorCodebitor3.setEnabled(true);
						inputCreditorCodebitor3.setBackground(Color.WHITE);

						inputSumaInitialaCodebitor3.setEnabled(true);
						inputSumaInitialaCodebitor3.setBackground(Color.WHITE);

						inputRataLunaraCodebitor3.setEnabled(true);
						inputRataLunaraCodebitor3.setBackground(Color.WHITE);

						inputSoldCreditCodebitor3.setEnabled(true);
						inputSoldCreditCodebitor3.setBackground(Color.WHITE);

						inputDataContractareCodebitor3.setEnabled(true);
						inputDataContractareCodebitor3.setBackground(Color.WHITE);

						inputScadentaCodebitor3.setEnabled(true);
						inputScadentaCodebitor3.setBackground(Color.WHITE);

						refinanteazaCodebitor3.setEnabled(true);
						intarzieriCodebitor3.setEnabled(true);
						inchideCodebitor3.setEnabled(true);
							
						// row23
						inputTipCreditCodebitor4.setEnabled(true);
						inputTipCreditCodebitor4.setBackground(Color.WHITE);

						inputCreditorCodebitor4.setEnabled(true);
						inputCreditorCodebitor4.setBackground(Color.WHITE);

						inputSumaInitialaCodebitor4.setEnabled(true);
						inputSumaInitialaCodebitor4.setBackground(Color.WHITE);

						inputRataLunaraCodebitor4.setEnabled(true);
						inputRataLunaraCodebitor4.setBackground(Color.WHITE);

						inputSoldCreditCodebitor4.setEnabled(true);
						inputSoldCreditCodebitor4.setBackground(Color.WHITE);

						inputDataContractareCodebitor4.setEnabled(true);
						inputDataContractareCodebitor4.setBackground(Color.WHITE);
	
						inputScadentaCodebitor4.setEnabled(true);
						inputScadentaCodebitor4.setBackground(Color.WHITE);

						refinanteazaCodebitor4.setEnabled(true);
						intarzieriCodebitor4.setEnabled(true);
						inchideCodebitor4.setEnabled(true);
					}	
					
					if(!temp.isSelected())
					{
						// row20
						inputTipCreditCodebitor1.setEnabled(false);
						inputTipCreditCodebitor1.setBackground(Color.LIGHT_GRAY);
													
						inputCreditorCodebitor1.setEnabled(false);
						inputCreditorCodebitor1.setBackground(Color.LIGHT_GRAY);
																		
						inputSumaInitialaCodebitor1.setEnabled(false);
						inputSumaInitialaCodebitor1.setBackground(Color.LIGHT_GRAY);
						
						inputRataLunaraCodebitor1.setEnabled(false);
						inputRataLunaraCodebitor1.setBackground(Color.LIGHT_GRAY);
													
						inputSoldCreditCodebitor1.setEnabled(false);
						inputSoldCreditCodebitor1.setBackground(Color.LIGHT_GRAY);
													
						inputDataContractareCodebitor1.setEnabled(false);
						inputDataContractareCodebitor1.setBackground(Color.LIGHT_GRAY);
						
						inputScadentaCodebitor1.setEnabled(false);
						inputScadentaCodebitor1.setBackground(Color.LIGHT_GRAY);
						
						refinanteazaCodebitor1.setEnabled(false);
						intarzieriCodebitor1.setEnabled(false);
						inchideCodebitor1.setEnabled(false);
					
						// row21
						inputTipCreditCodebitor2.setEnabled(false);
						inputTipCreditCodebitor2.setBackground(Color.LIGHT_GRAY);

						inputCreditorCodebitor2.setEnabled(false);
						inputCreditorCodebitor2.setBackground(Color.LIGHT_GRAY);

						inputSumaInitialaCodebitor2.setEnabled(false);
						inputSumaInitialaCodebitor2.setBackground(Color.LIGHT_GRAY);

						inputRataLunaraCodebitor2.setEnabled(false);
						inputRataLunaraCodebitor2.setBackground(Color.LIGHT_GRAY);

						inputSoldCreditCodebitor2.setEnabled(false);
						inputSoldCreditCodebitor2.setBackground(Color.LIGHT_GRAY);

						inputDataContractareCodebitor2.setEnabled(false);
						inputDataContractareCodebitor2.setBackground(Color.LIGHT_GRAY);

						inputScadentaCodebitor2.setEnabled(false);
						inputScadentaCodebitor2.setBackground(Color.LIGHT_GRAY);

						refinanteazaCodebitor2.setEnabled(false);
						intarzieriCodebitor2.setEnabled(false);
						inchideCodebitor2.setEnabled(false);
						
						// row22

						inputTipCreditCodebitor3.setEnabled(false);
						inputTipCreditCodebitor3.setBackground(Color.LIGHT_GRAY);

						inputCreditorCodebitor3.setEnabled(false);
						inputCreditorCodebitor3.setBackground(Color.LIGHT_GRAY);

						inputSumaInitialaCodebitor3.setEnabled(false);
						inputSumaInitialaCodebitor3.setBackground(Color.LIGHT_GRAY);

						inputRataLunaraCodebitor3.setEnabled(false);
						inputRataLunaraCodebitor3.setBackground(Color.LIGHT_GRAY);

						inputSoldCreditCodebitor3.setEnabled(false);
						inputSoldCreditCodebitor3.setBackground(Color.LIGHT_GRAY);

						inputDataContractareCodebitor3.setEnabled(false);
						inputDataContractareCodebitor3.setBackground(Color.LIGHT_GRAY);

						inputScadentaCodebitor3.setEnabled(false);
						inputScadentaCodebitor3.setBackground(Color.LIGHT_GRAY);

						refinanteazaCodebitor3.setEnabled(false);
						intarzieriCodebitor3.setEnabled(false);
						inchideCodebitor3.setEnabled(false);
							
						// row23
						inputTipCreditCodebitor4.setEnabled(false);
						inputTipCreditCodebitor4.setBackground(Color.LIGHT_GRAY);

						inputCreditorCodebitor4.setEnabled(false);
						inputCreditorCodebitor4.setBackground(Color.LIGHT_GRAY);

						inputSumaInitialaCodebitor4.setEnabled(false);
						inputSumaInitialaCodebitor4.setBackground(Color.LIGHT_GRAY);

						inputRataLunaraCodebitor4.setEnabled(false);
						inputRataLunaraCodebitor4.setBackground(Color.LIGHT_GRAY);

						inputSoldCreditCodebitor4.setEnabled(false);
						inputSoldCreditCodebitor4.setBackground(Color.LIGHT_GRAY);

						inputDataContractareCodebitor4.setEnabled(false);
						inputDataContractareCodebitor4.setBackground(Color.LIGHT_GRAY);
	
						inputScadentaCodebitor4.setEnabled(false);
						inputScadentaCodebitor4.setBackground(Color.LIGHT_GRAY);

						refinanteazaCodebitor4.setEnabled(false);
						intarzieriCodebitor4.setEnabled(false);
						inchideCodebitor4.setEnabled(false);
					}
				}
			});
			codebitor.add(istoricCreditareCodebitor);
			
			// row17
			numarImobileCodebitor = new JLabel("Nr. imobile");
			numarImobileCodebitor.setFont(font);
			codebitor.add(numarImobileCodebitor);
			
			inputNumarImobileCodebitor = new JTextField(2);
			codebitor.add(inputNumarImobileCodebitor);
			
			PADCodebitor = new JLabel("PAD");
			PADCodebitor.setFont(font);
			codebitor.add(PADCodebitor);
			
			inputPADCodebitor = new JTextField(3);
			codebitor.add(inputPADCodebitor);
			
			asigurareCodebitor = new JLabel("Asigurare");
			asigurareCodebitor.setFont(font);
			codebitor.add(asigurareCodebitor);
			
			inputAsigurareCodebitor = new JTextField(3);
			codebitor.add(inputAsigurareCodebitor);
			
			impozitCodebitor = new JLabel("Impozit");
			impozitCodebitor.setFont(font);
			codebitor.add(impozitCodebitor);
			
			inputImpozitCodebitor = new JTextField(3);
			codebitor.add(inputImpozitCodebitor);
			
			numarMasiniCodebitor = new JLabel("Nr. masini");
			numarMasiniCodebitor.setFont(font);
			codebitor.add(numarMasiniCodebitor);
			
			inputNumarMasiniCodebitor = new JTextField(2);
			codebitor.add(inputNumarMasiniCodebitor);
			
			RCACodebitor = new JLabel("RCA");
			RCACodebitor.setFont(font);
			codebitor.add(RCACodebitor);
			
			inputRCACodebitor = new JTextField(3);
			codebitor.add(inputRCACodebitor);
							
			cascoCodebitor = new JLabel("Casco");
			cascoCodebitor.setFont(font);
			codebitor.add(cascoCodebitor);
			
			inputCascoCodebitor = new JTextField(3);
			codebitor.add(inputCascoCodebitor);
			
			impozitMasinaCodebitor = new JLabel("Impozit");
			impozitMasinaCodebitor.setFont(font);
			codebitor.add(impozitMasinaCodebitor);
			
			inputImpozitMasinaCodebitor = new JTextField(3);
			codebitor.add(inputImpozitMasinaCodebitor);
			
			
			// row18
			numarMembriFamilieCodebitor = new JLabel("<html><center>" + "Nr. membri" + "<br>" + "familie" + "</center></html>");
			numarMembriFamilieCodebitor.setFont(font);
			codebitor.add(numarMembriFamilieCodebitor);
			
			inputNumarMembriFamilieCodebitor = new JTextField(2);
			codebitor.add(inputNumarMembriFamilieCodebitor);
			
			numarCopiiCodebitor = new JLabel("<html><center>" + "Nr. copii" + "<br>" + "intretinere" + "</center></html>");
			numarCopiiCodebitor.setFont(font);
			codebitor.add(numarCopiiCodebitor);
			
			inputNumarCopiiCodebitor = new JTextField(2);
			codebitor.add(inputNumarCopiiCodebitor);
			
			numarPersoaneIntretinereCodebitor = new JLabel("<html><center>" + "Nr. persoane" + "<br>" + "intretinere" + "</center></html>");
			numarPersoaneIntretinereCodebitor.setFont(font);
			codebitor.add(numarPersoaneIntretinereCodebitor);
			
			inputNumarPersoaneIntretinereCodebitor = new JTextField(2);
			codebitor.add(inputNumarPersoaneIntretinereCodebitor);
			
			inputSituatieFamilialaCodebitor = new JComboBox<String>(situatieFamilialaType);
			codebitor.add(inputSituatieFamilialaCodebitor);
			
			// padding for row18
			JTextField padding3 = new JTextField(23);
			padding3.setEnabled(false);
			padding3.setBackground(this.getBackground());
			padding3.setBorder(null);
			codebitor.add(padding3);
			
			// row19
			tipCreditCodebitor = new JLabel(String.format("%-7s"," Tip "));
			tipCreditCodebitor.setFont(font);
			codebitor.add(tipCreditCodebitor);
			
			creditorCodebitor = new JLabel(String.format("%-24s", "Creditor"));
			creditorCodebitor.setFont(font);
			codebitor.add(creditorCodebitor);
			
			sumaInitialaCodebitor = new JLabel("Suma initiala");
			sumaInitialaCodebitor.setFont(font);
			codebitor.add(sumaInitialaCodebitor);
			
			rataLunaraCodebitor = new JLabel("Rata lunar");
			rataLunaraCodebitor.setFont(font);
			codebitor.add(rataLunaraCodebitor);
			
			soldCreditCodebitor = new JLabel(String.format("%-18s", "Sold credit"));
			soldCreditCodebitor.setFont(font);
			codebitor.add(soldCreditCodebitor);
			
			dataContractareCodebitor = new JLabel("<html><center>" + "Data" + "<br>" + "contract" + "</center></html>");
			dataContractareCodebitor.setFont(font);
			codebitor.add(dataContractareCodebitor);
			
			scadentaCodebitor = new JLabel("     Scadenta");
			scadentaCodebitor.setFont(font);
			codebitor.add(scadentaCodebitor);
			// padding for row19
			JTextField padding4 = new JTextField(21);
			padding4.setEnabled(false);
			padding4.setBackground(this.getBackground());
			padding4.setBorder(null);
			codebitor.add(padding4);
			
			// row20
			inputTipCreditCodebitor1 = new JTextField(2);
			codebitor.add(inputTipCreditCodebitor1);
			
			inputCreditorCodebitor1 = new JTextField(7);
			codebitor.add(inputCreditorCodebitor1);
			
			inputSumaInitialaCodebitor1 = new JTextField(5);
			codebitor.add(inputSumaInitialaCodebitor1);
	
			inputRataLunaraCodebitor1 = new JTextField(3);
			codebitor.add(inputRataLunaraCodebitor1);
			
			inputSoldCreditCodebitor1 = new JTextField(5);
			codebitor.add(inputSoldCreditCodebitor1);
			
			inputDataContractareCodebitor1 = new JTextField(4);
			codebitor.add(inputDataContractareCodebitor1);
			
			inputScadentaCodebitor1 = new JTextField(4);
			codebitor.add(inputScadentaCodebitor1);
			
			refinanteazaCodebitor1 = new JCheckBox("Refinantare?");
			refinanteazaCodebitor1.setFont(font);
			codebitor.add(refinanteazaCodebitor1);
			
			intarzieriCodebitor1 = new JCheckBox("Intarzieri?");
			intarzieriCodebitor1.setFont(font);
			codebitor.add(intarzieriCodebitor1);
			
			inchideCodebitor1 = new JCheckBox("Se inchide?");
			inchideCodebitor1.setFont(font);
			codebitor.add(inchideCodebitor1);
			
			// row21
			inputTipCreditCodebitor2 = new JTextField(2);
			codebitor.add(inputTipCreditCodebitor2);
			
			inputCreditorCodebitor2 = new JTextField(7);
			codebitor.add(inputCreditorCodebitor2);
			
			inputSumaInitialaCodebitor2 = new JTextField(5);
			codebitor.add(inputSumaInitialaCodebitor2);
	
			inputRataLunaraCodebitor2 = new JTextField(3);
			codebitor.add(inputRataLunaraCodebitor2);
			
			inputSoldCreditCodebitor2 = new JTextField(5);
			codebitor.add(inputSoldCreditCodebitor2);
			
			inputDataContractareCodebitor2 = new JTextField(4);
			codebitor.add(inputDataContractareCodebitor2);
			
			inputScadentaCodebitor2 = new JTextField(4);
			codebitor.add(inputScadentaCodebitor2);
			
			refinanteazaCodebitor2 = new JCheckBox("Refinantare?");
			refinanteazaCodebitor2.setFont(font);
			codebitor.add(refinanteazaCodebitor2);
			
			intarzieriCodebitor2 = new JCheckBox("Intarzieri?");
			intarzieriCodebitor2.setFont(font);
			codebitor.add(intarzieriCodebitor2);
			
			inchideCodebitor2 = new JCheckBox("Se inchide?");
			inchideCodebitor2.setFont(font);
			codebitor.add(inchideCodebitor2);
			
			// row22
			inputTipCreditCodebitor3 = new JTextField(2);
			codebitor.add(inputTipCreditCodebitor3);
			
			inputCreditorCodebitor3 = new JTextField(7);
			codebitor.add(inputCreditorCodebitor3);
			
			inputSumaInitialaCodebitor3 = new JTextField(5);
			codebitor.add(inputSumaInitialaCodebitor3);
	
			inputRataLunaraCodebitor3 = new JTextField(3);
			codebitor.add(inputRataLunaraCodebitor3);
			
			inputSoldCreditCodebitor3 = new JTextField(5);
			codebitor.add(inputSoldCreditCodebitor3);
			
			inputDataContractareCodebitor3 = new JTextField(4);
			codebitor.add(inputDataContractareCodebitor3);
			
			inputScadentaCodebitor3 = new JTextField(4);
			codebitor.add(inputScadentaCodebitor3);
			
			refinanteazaCodebitor3 = new JCheckBox("Refinantare?");
			refinanteazaCodebitor3.setFont(font);
			codebitor.add(refinanteazaCodebitor3);
			
			intarzieriCodebitor3 = new JCheckBox("Intarzieri?");
			intarzieriCodebitor3.setFont(font);
			codebitor.add(intarzieriCodebitor3);
			
			inchideCodebitor3 = new JCheckBox("Se inchide?");
			inchideCodebitor3.setFont(font);
			codebitor.add(inchideCodebitor3);
			
			// row23
			inputTipCreditCodebitor4 = new JTextField(2);
			codebitor.add(inputTipCreditCodebitor4);
			
			inputCreditorCodebitor4 = new JTextField(7);
			codebitor.add(inputCreditorCodebitor4);
			
			inputSumaInitialaCodebitor4 = new JTextField(5);
			codebitor.add(inputSumaInitialaCodebitor4);
	
			inputRataLunaraCodebitor4 = new JTextField(3);
			codebitor.add(inputRataLunaraCodebitor4);
			
			inputSoldCreditCodebitor4 = new JTextField(5);
			codebitor.add(inputSoldCreditCodebitor4);
			
			inputDataContractareCodebitor4 = new JTextField(4);
			codebitor.add(inputDataContractareCodebitor4);
			
			inputScadentaCodebitor4 = new JTextField(4);
			codebitor.add(inputScadentaCodebitor4);
			
			refinanteazaCodebitor4 = new JCheckBox("Refinantare?");
			refinanteazaCodebitor4.setFont(font);
			codebitor.add(refinanteazaCodebitor4);
			
			intarzieriCodebitor4 = new JCheckBox("Intarzieri?");
			intarzieriCodebitor4.setFont(font);
			codebitor.add(intarzieriCodebitor4);
			
			inchideCodebitor4 = new JCheckBox("Se inchide?");
			inchideCodebitor4.setFont(font);
			codebitor.add(inchideCodebitor4);		
		
			// Laziness at its best - all disabled fields here because to lazy to put where they are supposed to be
				inputTipCreditCodebitor1.setEnabled(false);
				inputTipCreditCodebitor1.setBackground(Color.LIGHT_GRAY);
											
				inputCreditorCodebitor1.setEnabled(false);
				inputCreditorCodebitor1.setBackground(Color.LIGHT_GRAY);
																
				inputSumaInitialaCodebitor1.setEnabled(false);
				inputSumaInitialaCodebitor1.setBackground(Color.LIGHT_GRAY);
				
				inputRataLunaraCodebitor1.setEnabled(false);
				inputRataLunaraCodebitor1.setBackground(Color.LIGHT_GRAY);
											
				inputSoldCreditCodebitor1.setEnabled(false);
				inputSoldCreditCodebitor1.setBackground(Color.LIGHT_GRAY);
											
				inputDataContractareCodebitor1.setEnabled(false);
				inputDataContractareCodebitor1.setBackground(Color.LIGHT_GRAY);
				
				inputScadentaCodebitor1.setEnabled(false);
				inputScadentaCodebitor1.setBackground(Color.LIGHT_GRAY);
				
				refinanteazaCodebitor1.setEnabled(false);
				intarzieriCodebitor1.setEnabled(false);
				inchideCodebitor1.setEnabled(false);
			
				// row21
				inputTipCreditCodebitor2.setEnabled(false);
				inputTipCreditCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				inputCreditorCodebitor2.setEnabled(false);
				inputCreditorCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				inputSumaInitialaCodebitor2.setEnabled(false);
				inputSumaInitialaCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				inputRataLunaraCodebitor2.setEnabled(false);
				inputRataLunaraCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				inputSoldCreditCodebitor2.setEnabled(false);
				inputSoldCreditCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				inputDataContractareCodebitor2.setEnabled(false);
				inputDataContractareCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				inputScadentaCodebitor2.setEnabled(false);
				inputScadentaCodebitor2.setBackground(Color.LIGHT_GRAY);
	
				refinanteazaCodebitor2.setEnabled(false);
				intarzieriCodebitor2.setEnabled(false);
				inchideCodebitor2.setEnabled(false);
				
				// row22
	
				inputTipCreditCodebitor3.setEnabled(false);
				inputTipCreditCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				inputCreditorCodebitor3.setEnabled(false);
				inputCreditorCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				inputSumaInitialaCodebitor3.setEnabled(false);
				inputSumaInitialaCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				inputRataLunaraCodebitor3.setEnabled(false);
				inputRataLunaraCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				inputSoldCreditCodebitor3.setEnabled(false);
				inputSoldCreditCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				inputDataContractareCodebitor3.setEnabled(false);
				inputDataContractareCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				inputScadentaCodebitor3.setEnabled(false);
				inputScadentaCodebitor3.setBackground(Color.LIGHT_GRAY);
	
				refinanteazaCodebitor3.setEnabled(false);
				intarzieriCodebitor3.setEnabled(false);
				inchideCodebitor3.setEnabled(false);
				
			// row23
			inputTipCreditCodebitor4.setEnabled(false);
			inputTipCreditCodebitor4.setBackground(Color.LIGHT_GRAY);

			inputCreditorCodebitor4.setEnabled(false);
			inputCreditorCodebitor4.setBackground(Color.LIGHT_GRAY);

			inputSumaInitialaCodebitor4.setEnabled(false);
			inputSumaInitialaCodebitor4.setBackground(Color.LIGHT_GRAY);

			inputRataLunaraCodebitor4.setEnabled(false);
			inputRataLunaraCodebitor4.setBackground(Color.LIGHT_GRAY);

			inputSoldCreditCodebitor4.setEnabled(false);
			inputSoldCreditCodebitor4.setBackground(Color.LIGHT_GRAY);

			inputDataContractareCodebitor4.setEnabled(false);
			inputDataContractareCodebitor4.setBackground(Color.LIGHT_GRAY);

			inputScadentaCodebitor4.setEnabled(false);
			inputScadentaCodebitor4.setBackground(Color.LIGHT_GRAY);

			refinanteazaCodebitor4.setEnabled(false);
			intarzieriCodebitor4.setEnabled(false);
			inchideCodebitor4.setEnabled(false);
						
			
		tabbedPane.addTab("Codebitor", null, codebitor, "Info codebitor");
		tabbedPane.setEnabledAt(1, false);			
		this.add(tabbedPane, BorderLayout.CENTER);
		
		infoLabel = new JLabel("Info area");
		this.add(infoLabel, BorderLayout.SOUTH);
	}
	
	private class MenuHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent menuEvent)
		{
			JMenuItem actionMenu = (JMenuItem) menuEvent.getSource();
			
			if(actionMenu == fileSave)
			{
				String outputPath = Paths.get("Output/" + inputNumeTitular.getText() + inputPrenumeTitular.getText() +"/").toString();
				saveObjectTitular(outputPath);
			}
			
			if(actionMenu == fileSaveCodebitor)
			{
				String outputPath = Paths.get("Output/" + inputNumeTitular.getText() + inputPrenumeTitular.getText() +"/").toString();
				saveObjectCodebitor(outputPath);
			}
			
			if(actionMenu == fileOpen)
			{
				JFileChooser fileChooser = new JFileChooser("Output/");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(tabbedPane);
				
				if(result != JFileChooser.CANCEL_OPTION)
				{
					Path object = fileChooser.getSelectedFile().toPath();
					openObjectTitular(object);
					tabbedPane.setSelectedIndex(0);
				}
				
			}
			
			if(actionMenu == fileOpenCodebitor)
			{
				JFileChooser fileChooser = new JFileChooser("Output/");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(tabbedPane);
				
				if(result != JFileChooser.CANCEL_OPTION)
				{
					Path object = fileChooser.getSelectedFile().toPath();
					openObjectCodebitor(object);
					areCodebitor.setSelected(true);
					tabbedPane.setEnabledAt(1, true);
					tabbedPane.setSelectedIndex(1);
					
				}
				
			}
			
			if(actionMenu == fileQuit)
			{
				System.exit(0);
			}
			
			if(actionMenu == printFisk)
			{
				saveTitular();
				
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				fillTemplate(FISK_DINAMIC_PATH, outputPath, "Fisk", templateTitularTokens, informationTitularTokens);
				
				if(areCodebitor.isSelected())
				{
					saveCodebitor();
					fillTemplate(FISK_DINAMIC_PATH, outputPath, "FiskCodebitor", templateTitularTokens, informationCodebitorTokens);
				}
				
				infoLabel.setText("Se printeaza Fisk");
				
			}
			
			if(actionMenu == printFisa)
			{
				saveTitular();
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				fillExcelTemplate(FISA_DINAMIC_PATH, outputPath, "Fisa", templateTitularTokens, informationTitularTokens);
				
				if(areCodebitor.isSelected())
				{
					saveCodebitor();
					fillExcelTemplate(FISA_DINAMIC_PATH, outputPath, "FisaCodebitor", templateTitularTokens, informationCodebitorTokens);
				}
				
				
				infoLabel.setText("Se printeaza Fisa");
			}
			
			if(actionMenu == printAlpha)
			{
				infoLabel.setText("Se printeaza Alpha");								
			}
			
			if(actionMenu == printBcr)
			{
				saveTitular();
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				if(!areCodebitor.isSelected())
					fillTemplate(BCR_DINAMIC_PATH, outputPath, "BCR", templateTitularTokens, informationTitularTokens);
				
				else
				{
					saveCodebitor();
					fillCommonTemplate(BCR_COMMON_DINAMIC_PATH, outputPath, "BCR", templateTitularTokens, informationTitularTokens,
							templateCodebitorTokens, informationCodebitorTokens);
				}
				
				infoLabel.setText("Se printeaza BCR");
			}
			
			if(actionMenu == printCetelem)
			{
				saveTitular();
				
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				fillTemplate(CETELEM_DINAMIC_PATH, outputPath, "BNPParibas", templateTitularTokens, informationTitularTokens);
				
				if(areCodebitor.isSelected())
				{
					saveCodebitor();
					fillTemplate(CETELEM_DINAMIC_PATH, outputPath, "BNPParibasCodebitor", templateTitularTokens, informationCodebitorTokens);
				}
												
				infoLabel.setText("Se printeaza BNP Paribas");
			}
				
			if(actionMenu == printGaranti)
			{
				saveTitular();
				
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				fillTemplate(GARANTI_DINAMIC_PATH, outputPath, "Garanti", templateTitularTokens, informationTitularTokens);
				
				if(areCodebitor.isSelected())
				{
					saveCodebitor();
					fillTemplate(GARANTI_DINAMIC_PATH, outputPath, "GarantiCodebitor", templateTitularTokens, informationCodebitorTokens);
				}
				infoLabel.setText("Se printeaza Garanti");
			}
			
			if(actionMenu == printIdea)
			{
				saveTitular();
				
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				fillTemplate(IDEA_DINAMIC_PATH, outputPath, "Idea", templateTitularTokens, informationTitularTokens);
				
				if(areCodebitor.isSelected())
				{
					saveCodebitor();
					fillTemplate(IDEA_DINAMIC_PATH, outputPath, "IdeaCodebitor", templateTitularTokens, informationCodebitorTokens);
				}
				infoLabel.setText("Se printeaza Idea");
			}
			
			if(actionMenu == printOtp)
			{
				saveTitular();
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				if(!areCodebitor.isSelected())
				{
					fillTemplate(OTP_DINAMIC_PATH, outputPath, "OTP", templateTitularTokens, informationTitularTokens);
					fillTemplate(OTP_CERERE_DINAMIC_PATH, outputPath, "OTPCerere", templateTitularTokens, informationTitularTokens);
				}
				
				else
				{
					saveCodebitor();
					fillTemplate(OTP_DINAMIC_PATH, outputPath, "OTP", templateTitularTokens, informationTitularTokens);
					fillTemplate(OTP_DINAMIC_PATH, outputPath, "OTPCodebitor", templateTitularTokens, informationCodebitorTokens);
					fillCommonTemplate(OTP_COMMON_DINAMIC_PATH, outputPath, "OTPCerere", templateTitularTokens, informationTitularTokens,
							templateCodebitorTokens, informationCodebitorTokens);
				}
			}
			
			if(actionMenu == printPiraeus)
			{
				infoLabel.setText("Se printeaza Piraeus");
			}
			
			if(actionMenu == printUnicredit)
			{
				saveTitular();
				String outputPath = Paths.get("Output/" + informationTitularTokens[0] + informationTitularTokens[1] +"/").toString();
				
				if(!areCodebitor.isSelected())
					fillTemplate(UNICREDIT_DINAMIC_PATH, outputPath, "Unicredit", templateTitularTokens, informationTitularTokens);
				
				else
				{
					saveCodebitor();
					fillCommonTemplate(UNICREDIT_COMMON_DINAMIC_PATH, outputPath, "Unicredit", templateTitularTokens, informationTitularTokens,
							templateCodebitorTokens, informationCodebitorTokens);
				}
				
				infoLabel.setText("Se printeaza Unicredit");
			}
						
			if(actionMenu == helpHelp)
			{
				JOptionPane.showMessageDialog(tabbedPane,"Prescoring Kiwi\n" +
					"\n" +
					"Completati informatiile necesare in formular.\n" +
					"Dupa cumpletare, din meniul Print se pot genera\n" +
					"formularele necesare prescoringului.\n" +
					"Formularele se regasesc in folderul Output");
			}
			
			if(actionMenu == helpAbout)
			{
				JOptionPane.showMessageDialog(tabbedPane,"Prescoring Kiwi\n" +
					"\n" +
					"Versiunea 1.00\n" +
					"By Cozmanca Alexandru\n" +
					"Copyright 2018");
			}
						
		}
	}
	
	public static void saveTitular()
	{				
		informationTitularTokens[NUME] = inputNumeTitular.getText();
		informationTitularTokens[PRENUME] = inputPrenumeTitular.getText();
		informationTitularTokens[CNP] = inputCNPTitular.getText();
		informationTitularTokens[EMAIL] = inputEmailTitular.getText();
		informationTitularTokens[ID] = IDType[IDTitular.getSelectedIndex()];

		// id number and serie parsing
			String temp = inputIDTitular.getText();
			temp = temp.toUpperCase();
			String serie = "";
			
			if(temp.matches("[A-Z][A-Z] [0-9][0-9][0-9][0-9][0-9][0-9]"))
			{
				serie = temp.substring(0, 2);
				temp = temp.substring(3, temp.length());
			}
			else if(temp.matches("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]"))
			{	
				serie = temp.substring(0, 2);
				temp = temp.substring(2, temp.length());
			}
			informationTitularTokens[NR_ID] = temp; 
			informationTitularTokens[SERIE] = serie;
		
		informationTitularTokens[LA_DATA] = inputDataEliberareTitular.getText();
		informationTitularTokens[ELIBERAT_DE] = inputEliberatDeTitular.getText();
		informationTitularTokens[ADRESA] = inputAdresaTitular.getText();
		informationTitularTokens[DATA_NASTERE] = inputDataNastereTitular.getText();
		informationTitularTokens[LOCALITATE_NASTERE] = inputLocalitateNastereTitular.getText();
		informationTitularTokens[RESEDINTA] = inputResedintaTitular.getText();
		informationTitularTokens[SITUATIE_LOCATIVA] = situatieLocativaType[inputSituatieLocativaTitular.getSelectedIndex()];
		informationTitularTokens[VECHIME_ADRESA] = inputVechimeAdresaTitular.getText();
		informationTitularTokens[FUNCTIE] = inputFunctieTitular.getText();
		informationTitularTokens[ANGAJATOR] = inputAngajatorTitular.getText();
		informationTitularTokens[VECHIME_TOTALA] = inputVechimeTotalaTitular.getText();
		informationTitularTokens[SITUATIE_FAMILIALA]  = situatieFamilialaType[inputSituatieFamilialaTitular.getSelectedIndex()];
		informationTitularTokens[NUMAR_MEMBRI_FAMILIE] = inputNumarMembriFamilieTitular.getText();
		informationTitularTokens[TELEFON_ANGAJATOR] = inputTelAngajatorTitular.getText();
		informationTitularTokens[TELEFON_FIX] = inputFixTitular.getText();
		informationTitularTokens[TELEFON_MOBIL] = inputMobilTitular.getText();
		informationTitularTokens[NUME_MAMA] = inputNumeMamaTitular.getText();
		informationTitularTokens[PRENUME_TATA] = inputPrenumeTataTitular.getText();
		informationTitularTokens[CNP_SOT] = inputCNPSotTitular.getText();
		informationTitularTokens[VALABIL_PANA_DATA] = inputValabilPanaDataTitular.getText();
		informationTitularTokens[NUME_SOT] = inputNumeSotTitular.getText();
		
		if(masinaTitular.isSelected())
			informationTitularTokens[MASINA] = "DA";
		else
			informationTitularTokens[MASINA] = "NU";
		
		informationTitularTokens[STUDII]  = studiiType[inputStudiiTitular.getSelectedIndex()];
		informationTitularTokens[TIP_IMOBIL]  = tipImobilType[inputTipImobilTitular.getSelectedIndex()];
		informationTitularTokens[TIP_VENIT]  = venitType[inputTipVenitTitular1.getSelectedIndex()];
		informationTitularTokens[CUI] = inputCUITitular.getText();
		informationTitularTokens[NR_ANGAJATI] = inputNrAngajatiTitular.getText();
		informationTitularTokens[DATA_INFIINTARE] = inputDataInfiintareTitular.getText();
		informationTitularTokens[ADRESA_ANGAJATOR] = inputAdresaAngajatorTitular.getText();
		informationTitularTokens[DATA_ANGAJARE] = inputDataAngajareTitular.getText();
		informationTitularTokens[DOMENIU]  = inputDomeniuTitular.getText();
		informationTitularTokens[CAPITAL]  = capitalType[inputCapitalTitular.getSelectedIndex()];
		informationTitularTokens[CAEN]  = inputCAENTitular.getText();
		
		if(multinationalaTitular.isSelected())
			informationTitularTokens[MULTINATIONALA] = "DA";
		else
			informationTitularTokens[MULTINATIONALA] = "NU";
		
		informationTitularTokens[TIP_SOCIETATE]  = societateType[inputTipSocietateTitular.getSelectedIndex()];
		informationTitularTokens[PROFESIE]  = inputProfesieTitular.getText();
		informationTitularTokens[TIP_FUNCTIE]  = functieType[inputTipFunctieTitular.getSelectedIndex()];
		informationTitularTokens[VECHIME_ULTIM_ANGAJATOR]  = inputVechimeUltimAngajatorTitular.getText();
		informationTitularTokens[BONURI_MASA]  = inputBonuriMasaTitular.getText();
		informationTitularTokens[VENIT_3LUNI]  = inputVenit3LuniTitular.getText();
		informationTitularTokens[VENIT_6LUNI]  = inputVenit6LuniTitular.getText();
		informationTitularTokens[VENIT_12LUNI]  = inputVenit12LuniTitular.getText();
		informationTitularTokens[TIP_VENIT_3LUNI]  = inputTipVenit3LuniTitular.getText();
		informationTitularTokens[TIP_VENIT_6LUNI]  = inputTipVenit6LuniTitular.getText();
		informationTitularTokens[TIP_VENIT_12LUNI]  = inputTipVenit12LuniTitular.getText();
		informationTitularTokens[VENIT_CURENT1]  = inputVenitCurentTitular1.getText();
		informationTitularTokens[VENIT_AN_PRECEDENT1]  = inputVenitAnPrecedentTitular1.getText();
		informationTitularTokens[TIP_VENIT1]  = venitType[inputTipVenitTitular1.getSelectedIndex()];
		informationTitularTokens[VENIT_CURENT2]  = inputVenitCurentTitular2.getText();
		informationTitularTokens[VENIT_AN_PRECEDENT2]  = inputVenitAnPrecedentTitular2.getText();
		informationTitularTokens[TIP_VENIT2]  = venitType[inputTipVenitTitular2.getSelectedIndex()];
		informationTitularTokens[VENIT_CURENT3]  = inputVenitCurentTitular3.getText();
		informationTitularTokens[VENIT_AN_PRECEDENT3]  = inputVenitAnPrecedentTitular3.getText();
		informationTitularTokens[TIP_VENIT3]  = venitType[inputTipVenitTitular3.getSelectedIndex()];
		informationTitularTokens[CONTRACT]  = contractType[inputContractMuncaTitular.getSelectedIndex()];
		informationTitularTokens[DATA_EXPIRARE_CONTRACT]  = inputDataExpirareContractTitular.getText();
		
		if(marireTitular.isSelected())
			informationTitularTokens[MARIRE] = "DA";
		else
			informationTitularTokens[MARIRE] = "NU";
		
		if(conventieSalarialaTitular.isSelected())
			informationTitularTokens[CONVENTIE] = "DA";
		else
			informationTitularTokens[CONVENTIE] = "NU";
		
		informationTitularTokens[BANCA_CONVENTIE]  = inputBancaConventieTitular.getText();
		informationTitularTokens[CONTURI]  = inputConturiBanciTitular.getText();
		
		if(istoricCreditareTitular.isSelected())
			informationTitularTokens[ISTORIC] = "DA";
		else
			informationTitularTokens[ISTORIC] = "NU";
		
		informationTitularTokens[NR_IMOBILE]  = inputNumarImobileTitular.getText();
		informationTitularTokens[PAD]  = inputPADTitular.getText();
		informationTitularTokens[ASIGURARE]  = inputAsigurareTitular.getText();
		informationTitularTokens[IMPOZIT]  = inputImpozitTitular.getText();
		informationTitularTokens[NR_MASINI]  = inputNumarMasiniTitular.getText();
		informationTitularTokens[RCA]  = inputRCATitular.getText();
		informationTitularTokens[CASCO]  = inputCascoTitular.getText();
		informationTitularTokens[IMPOZIT_MASINA]  = inputImpozitMasinaTitular.getText();
		informationTitularTokens[NUMAR_COPII]  = inputNumarCopiiTitular.getText();
		informationTitularTokens[NUMAR_PERSOANE_INTRETINERE]  = inputNumarPersoaneIntretinereTitular.getText();
		
		informationTitularTokens[TIP_CREDIT1]  = inputTipCreditTitular1.getText();
		informationTitularTokens[CREDITOR1]  = inputCreditorTitular1.getText();
		informationTitularTokens[SUMA_INITIALA1]  = inputSumaInitialaTitular1.getText();
		informationTitularTokens[RATA_LUNARA1]  = inputRataLunaraTitular1.getText();
		informationTitularTokens[SOLD_CREDIT1]  = inputSoldCreditTitular1.getText();
		informationTitularTokens[DATA_CONTRACTARE1]  = inputDataContractareTitular1.getText();
		informationTitularTokens[DATA_SCADENTA1]  = inputScadentaTitular1.getText();
		
		if(refinanteazaTitular1.isSelected())
			informationTitularTokens[REFINANTARE1] = "DA";
		else
			informationTitularTokens[REFINANTARE1] = "NU";
		
		if(intarzieriTitular1.isSelected())
			informationTitularTokens[INTARZIERE1] = "DA";
		else
			informationTitularTokens[INTARZIERE1] = "NU";
		
		if(inchideTitular1.isSelected())
			informationTitularTokens[INCHIDERE1] = "DA";
		else
			informationTitularTokens[INCHIDERE1] = "NU";
		
		informationTitularTokens[TIP_CREDIT2]  = inputTipCreditTitular2.getText();
		informationTitularTokens[CREDITOR2]  = inputCreditorTitular2.getText();
		informationTitularTokens[SUMA_INITIALA2]  = inputSumaInitialaTitular2.getText();
		informationTitularTokens[RATA_LUNARA2]  = inputRataLunaraTitular2.getText();
		informationTitularTokens[SOLD_CREDIT2]  = inputSoldCreditTitular2.getText();
		informationTitularTokens[DATA_CONTRACTARE2]  = inputDataContractareTitular2.getText();
		informationTitularTokens[DATA_SCADENTA2]  = inputScadentaTitular2.getText();
		
		if(refinanteazaTitular2.isSelected())
			informationTitularTokens[REFINANTARE2] = "DA";
		else
			informationTitularTokens[REFINANTARE2] = "NU";
		
		if(intarzieriTitular2.isSelected())
			informationTitularTokens[INTARZIERE2] = "DA";
		else
			informationTitularTokens[INTARZIERE2] = "NU";
		
		if(inchideTitular2.isSelected())
			informationTitularTokens[INCHIDERE2] = "DA";
		else
			informationTitularTokens[INCHIDERE2] = "NU";
		
		informationTitularTokens[TIP_CREDIT3]  = inputTipCreditTitular3.getText();
		informationTitularTokens[CREDITOR3]  = inputCreditorTitular3.getText();
		informationTitularTokens[SUMA_INITIALA3]  = inputSumaInitialaTitular3.getText();
		informationTitularTokens[RATA_LUNARA3]  = inputRataLunaraTitular3.getText();
		informationTitularTokens[SOLD_CREDIT3]  = inputSoldCreditTitular3.getText();
		informationTitularTokens[DATA_CONTRACTARE3]  = inputDataContractareTitular3.getText();
		informationTitularTokens[DATA_SCADENTA3]  = inputScadentaTitular3.getText();
		
		if(refinanteazaTitular3.isSelected())
			informationTitularTokens[REFINANTARE3] = "DA";
		else
			informationTitularTokens[REFINANTARE3] = "NU";
		
		if(intarzieriTitular3.isSelected())
			informationTitularTokens[INTARZIERE3] = "DA";
		else
			informationTitularTokens[INTARZIERE3] = "NU";
		
		if(inchideTitular3.isSelected())
			informationTitularTokens[INCHIDERE3] = "DA";
		else
			informationTitularTokens[INCHIDERE3] = "NU";
		
		informationTitularTokens[TIP_CREDIT4]  = inputTipCreditTitular4.getText();
		informationTitularTokens[CREDITOR4]  = inputCreditorTitular4.getText();
		informationTitularTokens[SUMA_INITIALA4]  = inputSumaInitialaTitular4.getText();
		informationTitularTokens[RATA_LUNARA4]  = inputRataLunaraTitular4.getText();
		informationTitularTokens[SOLD_CREDIT4]  = inputSoldCreditTitular4.getText();
		informationTitularTokens[DATA_CONTRACTARE4]  = inputDataContractareTitular4.getText();
		informationTitularTokens[DATA_SCADENTA4]  = inputScadentaTitular4.getText();
		
		if(refinanteazaTitular4.isSelected())
			informationTitularTokens[REFINANTARE4] = "DA";
		else
			informationTitularTokens[REFINANTARE4] = "NU";
		
		if(intarzieriTitular4.isSelected())
			informationTitularTokens[INTARZIERE4] = "DA";
		else
			informationTitularTokens[INTARZIERE4] = "NU";
		
		if(inchideTitular4.isSelected())
			informationTitularTokens[INCHIDERE4] = "DA";
		else
			informationTitularTokens[INCHIDERE4] = "NU";
		
		informationTitularTokens[BROKER]  = inputBroker.getText();
		informationTitularTokens[UNIT]  = inputUnit.getText();
		
		informationTitularTokens[ABONAMENT] = abonamentType[inputAbonamentTitular.getSelectedIndex()];
		
	}
	
	public static void saveCodebitor()
	{
		informationCodebitorTokens[NUME] = inputNumeCodebitor.getText();
		informationCodebitorTokens[PRENUME] = inputPrenumeCodebitor.getText();
		informationCodebitorTokens[CNP] = inputCNPCodebitor.getText();
		informationCodebitorTokens[EMAIL] = inputEmailCodebitor.getText();
		informationCodebitorTokens[ID] = IDType[IDCodebitor.getSelectedIndex()];
		
		// id number parsing
			String temp = inputIDCodebitor.getText();
			String serie = "";
			temp = temp.toUpperCase();
				
			if(temp.matches("[A-Z][A-Z] [0-9][0-9][0-9][0-9][0-9][0-9]"))
			{
				serie = temp.substring(0, 2);
				temp = temp.substring(3, temp.length());
			}
			else if(temp.matches("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]"))
			{
				serie = temp.substring(0, 2);
				temp = temp.substring(2, temp.length());
			}
				informationCodebitorTokens[NR_ID] = temp; 
				informationCodebitorTokens[SERIE] = serie;
		
		informationCodebitorTokens[LA_DATA] = inputDataEliberareCodebitor.getText();
		informationCodebitorTokens[ELIBERAT_DE] = inputEliberatDeCodebitor.getText();
		informationCodebitorTokens[ADRESA] = inputAdresaCodebitor.getText();
		informationCodebitorTokens[DATA_NASTERE] = inputDataNastereCodebitor.getText();
		informationCodebitorTokens[LOCALITATE_NASTERE] = inputLocalitateNastereCodebitor.getText();
		informationCodebitorTokens[RESEDINTA] = inputResedintaCodebitor.getText();
		informationCodebitorTokens[SITUATIE_LOCATIVA] = situatieLocativaType[inputSituatieLocativaCodebitor.getSelectedIndex()];
		informationCodebitorTokens[VECHIME_ADRESA] = inputVechimeAdresaCodebitor.getText();
		informationCodebitorTokens[FUNCTIE] = inputFunctieCodebitor.getText();
		informationCodebitorTokens[ANGAJATOR] = inputAngajatorCodebitor.getText();
		informationCodebitorTokens[VECHIME_TOTALA] = inputVechimeTotalaCodebitor.getText();
		informationCodebitorTokens[SITUATIE_FAMILIALA]  = situatieFamilialaType[inputSituatieFamilialaCodebitor.getSelectedIndex()];
		informationCodebitorTokens[NUMAR_MEMBRI_FAMILIE] = inputNumarMembriFamilieCodebitor.getText();
		informationCodebitorTokens[TELEFON_ANGAJATOR] = inputTelAngajatorCodebitor.getText();
		informationCodebitorTokens[TELEFON_FIX] = inputFixCodebitor.getText();
		informationCodebitorTokens[TELEFON_MOBIL] = inputMobilCodebitor.getText();
		
		informationCodebitorTokens[NUME_MAMA] = inputNumeMamaCodebitor.getText();
		informationCodebitorTokens[PRENUME_TATA] = inputPrenumeTataCodebitor.getText();
		informationCodebitorTokens[CNP_SOT] = inputCNPSotCodebitor.getText();
		informationCodebitorTokens[VALABIL_PANA_DATA] = inputValabilPanaDataCodebitor.getText();
		informationCodebitorTokens[NUME_SOT] = inputNumeSotCodebitor.getText();
		
		if(masinaCodebitor.isSelected())
			informationCodebitorTokens[MASINA] = "DA";
		else
			informationCodebitorTokens[MASINA] = "NU";
		
		informationCodebitorTokens[STUDII]  = studiiType[inputStudiiCodebitor.getSelectedIndex()];
		informationCodebitorTokens[TIP_IMOBIL]  = tipImobilType[inputTipImobilCodebitor.getSelectedIndex()];
		informationCodebitorTokens[TIP_VENIT]  = venitType[inputTipVenitCodebitor1.getSelectedIndex()];
		informationCodebitorTokens[CUI] = inputCUICodebitor.getText();
		informationCodebitorTokens[NR_ANGAJATI] = inputNrAngajatiCodebitor.getText();
		informationCodebitorTokens[DATA_INFIINTARE] = inputDataInfiintareCodebitor.getText();
		informationCodebitorTokens[ADRESA_ANGAJATOR] = inputAdresaAngajatorCodebitor.getText();
		informationCodebitorTokens[DATA_ANGAJARE] = inputDataAngajareCodebitor.getText();
		informationCodebitorTokens[DOMENIU]  = inputDomeniuCodebitor.getText();
		informationCodebitorTokens[CAPITAL]  = capitalType[inputCapitalCodebitor.getSelectedIndex()];
		informationCodebitorTokens[CAEN]  = inputCAENCodebitor.getText();
		
		if(multinationalaCodebitor.isSelected())
			informationCodebitorTokens[MULTINATIONALA] = "DA";
		else
			informationCodebitorTokens[MULTINATIONALA] = "NU";
		
		informationCodebitorTokens[TIP_SOCIETATE]  = societateType[inputTipSocietateCodebitor.getSelectedIndex()];
		informationCodebitorTokens[PROFESIE]  = inputProfesieCodebitor.getText();
		informationCodebitorTokens[TIP_FUNCTIE]  = functieType[inputTipFunctieCodebitor.getSelectedIndex()];
		informationCodebitorTokens[VECHIME_ULTIM_ANGAJATOR]  = inputVechimeUltimAngajatorCodebitor.getText();
		informationCodebitorTokens[BONURI_MASA]  = inputBonuriMasaCodebitor.getText();
		informationCodebitorTokens[VENIT_3LUNI]  = inputVenit3LuniCodebitor.getText();
		informationCodebitorTokens[VENIT_6LUNI]  = inputVenit6LuniCodebitor.getText();
		informationCodebitorTokens[VENIT_12LUNI]  = inputVenit12LuniCodebitor.getText();
		informationCodebitorTokens[TIP_VENIT_3LUNI]  = inputTipVenit3LuniCodebitor.getText();
		informationCodebitorTokens[TIP_VENIT_6LUNI]  = inputTipVenit6LuniCodebitor.getText();
		informationCodebitorTokens[TIP_VENIT_12LUNI]  = inputTipVenit12LuniCodebitor.getText();
		informationCodebitorTokens[VENIT_CURENT1]  = inputVenitCurentCodebitor1.getText();
		informationCodebitorTokens[VENIT_AN_PRECEDENT1]  = inputVenitAnPrecedentCodebitor1.getText();
		informationCodebitorTokens[TIP_VENIT1]  = venitType[inputTipVenitCodebitor1.getSelectedIndex()];
		informationCodebitorTokens[VENIT_CURENT2]  = inputVenitCurentCodebitor2.getText();
		informationCodebitorTokens[VENIT_AN_PRECEDENT2]  = inputVenitAnPrecedentCodebitor2.getText();
		informationCodebitorTokens[TIP_VENIT2]  = venitType[inputTipVenitCodebitor2.getSelectedIndex()];
		informationCodebitorTokens[VENIT_CURENT3]  = inputVenitCurentCodebitor3.getText();
		informationCodebitorTokens[VENIT_AN_PRECEDENT3]  = inputVenitAnPrecedentCodebitor3.getText();
		informationCodebitorTokens[TIP_VENIT3]  = venitType[inputTipVenitCodebitor3.getSelectedIndex()];
		informationCodebitorTokens[CONTRACT]  = contractType[inputContractMuncaCodebitor.getSelectedIndex()];
		informationCodebitorTokens[DATA_EXPIRARE_CONTRACT]  = inputDataExpirareContractCodebitor.getText();
		
		if(marireCodebitor.isSelected())
			informationCodebitorTokens[MARIRE] = "DA";
		else
			informationCodebitorTokens[MARIRE] = "NU";
		
		if(conventieSalarialaCodebitor.isSelected())
			informationCodebitorTokens[CONVENTIE] = "DA";
		else
			informationCodebitorTokens[CONVENTIE] = "NU";
		
		informationCodebitorTokens[BANCA_CONVENTIE]  = inputBancaConventieCodebitor.getText();
		informationCodebitorTokens[CONTURI]  = inputConturiBanciCodebitor.getText();
		
		if(istoricCreditareCodebitor.isSelected())
			informationCodebitorTokens[ISTORIC] = "DA";
		else
			informationCodebitorTokens[ISTORIC] = "NU";
		
		informationCodebitorTokens[NR_IMOBILE]  = inputNumarImobileCodebitor.getText();
		informationCodebitorTokens[PAD]  = inputPADCodebitor.getText();
		informationCodebitorTokens[ASIGURARE]  = inputAsigurareCodebitor.getText();
		informationCodebitorTokens[IMPOZIT]  = inputImpozitCodebitor.getText();
		informationCodebitorTokens[NR_MASINI]  = inputNumarMasiniCodebitor.getText();
		informationCodebitorTokens[RCA]  = inputRCACodebitor.getText();
		informationCodebitorTokens[CASCO]  = inputCascoCodebitor.getText();
		informationCodebitorTokens[IMPOZIT_MASINA]  = inputImpozitMasinaCodebitor.getText();
		informationCodebitorTokens[NUMAR_COPII]  = inputNumarCopiiCodebitor.getText();
		informationCodebitorTokens[NUMAR_PERSOANE_INTRETINERE]  = inputNumarPersoaneIntretinereCodebitor.getText();
		
		informationCodebitorTokens[TIP_CREDIT1]  = inputTipCreditCodebitor1.getText();
		informationCodebitorTokens[CREDITOR1]  = inputCreditorCodebitor1.getText();
		informationCodebitorTokens[SUMA_INITIALA1]  = inputSumaInitialaCodebitor1.getText();
		informationCodebitorTokens[RATA_LUNARA1]  = inputRataLunaraCodebitor1.getText();
		informationCodebitorTokens[SOLD_CREDIT1]  = inputSoldCreditCodebitor1.getText();
		informationCodebitorTokens[DATA_CONTRACTARE1]  = inputDataContractareCodebitor1.getText();
		informationCodebitorTokens[DATA_SCADENTA1]  = inputScadentaCodebitor1.getText();
		
		if(refinanteazaCodebitor1.isSelected())
			informationCodebitorTokens[REFINANTARE1] = "DA";
		else
			informationCodebitorTokens[REFINANTARE1] = "NU";
		
		if(intarzieriCodebitor1.isSelected())
			informationCodebitorTokens[INTARZIERE1] = "DA";
		else
			informationCodebitorTokens[INTARZIERE1] = "NU";
		
		if(inchideCodebitor1.isSelected())
			informationCodebitorTokens[INCHIDERE1] = "DA";
		else
			informationCodebitorTokens[INCHIDERE1] = "NU";
		
		informationCodebitorTokens[TIP_CREDIT2]  = inputTipCreditCodebitor2.getText();
		informationCodebitorTokens[CREDITOR2]  = inputCreditorCodebitor2.getText();
		informationCodebitorTokens[SUMA_INITIALA2]  = inputSumaInitialaCodebitor2.getText();
		informationCodebitorTokens[RATA_LUNARA2]  = inputRataLunaraCodebitor2.getText();
		informationCodebitorTokens[SOLD_CREDIT2]  = inputSoldCreditCodebitor2.getText();
		informationCodebitorTokens[DATA_CONTRACTARE2]  = inputDataContractareCodebitor2.getText();
		informationCodebitorTokens[DATA_SCADENTA2]  = inputScadentaCodebitor2.getText();
		
		if(refinanteazaCodebitor2.isSelected())
			informationCodebitorTokens[REFINANTARE2] = "DA";
		else
			informationCodebitorTokens[REFINANTARE2] = "NU";
		
		if(intarzieriCodebitor2.isSelected())
			informationCodebitorTokens[INTARZIERE2] = "DA";
		else
			informationCodebitorTokens[INTARZIERE2] = "NU";
		
		if(inchideCodebitor2.isSelected())
			informationCodebitorTokens[INCHIDERE2] = "DA";
		else
			informationCodebitorTokens[INCHIDERE2] = "NU";
		
		informationCodebitorTokens[TIP_CREDIT3]  = inputTipCreditCodebitor3.getText();
		informationCodebitorTokens[CREDITOR3]  = inputCreditorCodebitor3.getText();
		informationCodebitorTokens[SUMA_INITIALA3]  = inputSumaInitialaCodebitor3.getText();
		informationCodebitorTokens[RATA_LUNARA3]  = inputRataLunaraCodebitor3.getText();
		informationCodebitorTokens[SOLD_CREDIT3]  = inputSoldCreditCodebitor3.getText();
		informationCodebitorTokens[DATA_CONTRACTARE3]  = inputDataContractareCodebitor3.getText();
		informationCodebitorTokens[DATA_SCADENTA3]  = inputScadentaCodebitor3.getText();
		
		if(refinanteazaCodebitor3.isSelected())
			informationCodebitorTokens[REFINANTARE3] = "DA";
		else
			informationCodebitorTokens[REFINANTARE3] = "NU";
		
		if(intarzieriCodebitor3.isSelected())
			informationCodebitorTokens[INTARZIERE3] = "DA";
		else
			informationCodebitorTokens[INTARZIERE3] = "NU";
		
		if(inchideCodebitor3.isSelected())
			informationCodebitorTokens[INCHIDERE3] = "DA";
		else
			informationCodebitorTokens[INCHIDERE3] = "NU";
		
		informationCodebitorTokens[TIP_CREDIT4]  = inputTipCreditCodebitor4.getText();
		informationCodebitorTokens[CREDITOR4]  = inputCreditorCodebitor4.getText();
		informationCodebitorTokens[SUMA_INITIALA4]  = inputSumaInitialaCodebitor4.getText();
		informationCodebitorTokens[RATA_LUNARA4]  = inputRataLunaraCodebitor4.getText();
		informationCodebitorTokens[SOLD_CREDIT4]  = inputSoldCreditCodebitor4.getText();
		informationCodebitorTokens[DATA_CONTRACTARE4]  = inputDataContractareCodebitor4.getText();
		informationCodebitorTokens[DATA_SCADENTA4]  = inputScadentaCodebitor4.getText();
		
		if(refinanteazaCodebitor4.isSelected())
			informationCodebitorTokens[REFINANTARE4] = "DA";
		else
			informationCodebitorTokens[REFINANTARE4] = "NU";
		
		if(intarzieriCodebitor4.isSelected())
			informationCodebitorTokens[INTARZIERE4] = "DA";
		else
			informationCodebitorTokens[INTARZIERE4] = "NU";
		
		if(inchideCodebitor4.isSelected())
			informationCodebitorTokens[INCHIDERE4] = "DA";
		else
			informationCodebitorTokens[INCHIDERE4] = "NU";
		
		informationCodebitorTokens[BROKER]  = inputBroker.getText();
		informationCodebitorTokens[UNIT]  = inputUnit.getText();
		informationCodebitorTokens[ABONAMENT] = abonamentType[inputAbonamentCodebitor.getSelectedIndex()];
		
	}
	
	
	public static void saveObjectTitular(String outputPath)
	{
		Client titular = new Client();
		
		titular.setNume(inputNumeTitular.getText());
		titular.setPrenume(inputPrenumeTitular.getText());
		titular.setCNP(inputCNPTitular.getText());
		titular.setEmail(inputEmailTitular.getText());
		titular.setID(IDType[IDTitular.getSelectedIndex()]);

		// id number and serie parsing
			String temp = inputIDTitular.getText();
			temp = temp.toUpperCase();
			String serie = "";
			
			if(temp.matches("[A-Z][A-Z] [0-9][0-9][0-9][0-9][0-9][0-9]"))
			{
				serie = temp.substring(0, 2);
				temp = temp.substring(3, temp.length());
			}
			else if(temp.matches("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]"))
			{	
				serie = temp.substring(0, 2);
				temp = temp.substring(2, temp.length());
			}
			titular.setNrID(temp); 
			titular.setSerie(serie);
		
		titular.setLaData(inputDataEliberareTitular.getText());
		titular.setEliberatDe(inputEliberatDeTitular.getText());
		titular.setAdresa(inputAdresaTitular.getText());
		titular.setDataNastere(inputDataNastereTitular.getText());
		titular.setLocalitateNastere(inputLocalitateNastereTitular.getText());
		titular.setResedinta(inputResedintaTitular.getText());
		titular.setSituatieLocativa(situatieLocativaType[inputSituatieLocativaTitular.getSelectedIndex()]);
		titular.setVechimeAdresa(inputVechimeAdresaTitular.getText());
		titular.setFunctie(inputFunctieTitular.getText());
		titular.setAngajator(inputAngajatorTitular.getText());
		titular.setVechimeTotala(inputVechimeTotalaTitular.getText());
		titular.setSituatieFamiliala(situatieFamilialaType[inputSituatieFamilialaTitular.getSelectedIndex()]);
		titular.setNumarMembriFamilie(inputNumarMembriFamilieTitular.getText());
		titular.setTelefonAngajator(inputTelAngajatorTitular.getText());
		titular.setTelefonFix(inputFixTitular.getText());
		titular.setTelefonMobil(inputMobilTitular.getText());
		titular.setNumeMama(inputNumeMamaTitular.getText());
		titular.setPrenumeTata(inputPrenumeTataTitular.getText());
		titular.setCNPSot(inputCNPSotTitular.getText());
		titular.setValabilPanaData(inputValabilPanaDataTitular.getText());
		titular.setNumeSot(inputNumeSotTitular.getText());
		
		if(masinaTitular.isSelected())
			titular.setMasina("DA");
		else
			titular.setMasina("NU");
		
		titular.setStudii(studiiType[inputStudiiTitular.getSelectedIndex()]);
		titular.setTipImobil (tipImobilType[inputTipImobilTitular.getSelectedIndex()]);
		titular.setTipVenit (venitType[inputTipVenitTitular1.getSelectedIndex()]);
		titular.setCUI(inputCUITitular.getText());
		titular.setNrAngajati(inputNrAngajatiTitular.getText());
		titular.setDataInfiintare(inputDataInfiintareTitular.getText());
		titular.setAdresaAngajator(inputAdresaAngajatorTitular.getText());
		titular.setDataAngajare(inputDataAngajareTitular.getText());
		titular.setDomeniu(inputDomeniuTitular.getText());
		titular.setCapital(capitalType[inputCapitalTitular.getSelectedIndex()]);
		titular.setCAEN (inputCAENTitular.getText());
		
		if(multinationalaTitular.isSelected())
			titular.setMultinationala("DA");
		else
			titular.setMultinationala("NU");
		
		titular.setTipSocietate (societateType[inputTipSocietateTitular.getSelectedIndex()]);
		titular.setProfesie(inputProfesieTitular.getText());
		titular.setTipFunctie(functieType[inputTipFunctieTitular.getSelectedIndex()]);
		titular.setVechimeUltimAngajator (inputVechimeUltimAngajatorTitular.getText());
		titular.setBonuriMasa(inputBonuriMasaTitular.getText());
		titular.setVenit3Luni(inputVenit3LuniTitular.getText());
		titular.setVenit6Luni(inputVenit6LuniTitular.getText());
		titular.setVenit12Luni(inputVenit12LuniTitular.getText());
		titular.setTipVenit3Luni(inputTipVenit3LuniTitular.getText());
		titular.setTipVenit6Luni(inputTipVenit6LuniTitular.getText());
		titular.setTipVenit12Luni(inputTipVenit12LuniTitular.getText());
		titular.setVenitCurent1 (inputVenitCurentTitular1.getText());
		titular.setVenitAnPrecedent1 (inputVenitAnPrecedentTitular1.getText());
		titular.setTipVenit1 (venitType[inputTipVenitTitular1.getSelectedIndex()]);
		titular.setVenitCurent2 (inputVenitCurentTitular2.getText());
		titular.setVenitAnPrecedent2 (inputVenitAnPrecedentTitular2.getText());
		titular.setTipVenit2 (venitType[inputTipVenitTitular2.getSelectedIndex()]);
		titular.setVenitCurent3 (inputVenitCurentTitular3.getText());
		titular.setVenitAnPrecedent3 (inputVenitAnPrecedentTitular3.getText());
		titular.setTipVenit3 (venitType[inputTipVenitTitular3.getSelectedIndex()]);
		titular.setContract(contractType[inputContractMuncaTitular.getSelectedIndex()]);
		titular.setDataExpirareContract(inputDataExpirareContractTitular.getText());
		
		if(marireTitular.isSelected())
			titular.setMarire("DA");
		else
			titular.setMarire("NU");
		
		if(conventieSalarialaTitular.isSelected())
			titular.setConventie("DA");
		else
			titular.setConventie("NU");
		
		titular.setBancaConventie (inputBancaConventieTitular.getText());
		titular.setConturi(inputConturiBanciTitular.getText());
		
		if(istoricCreditareTitular.isSelected())
			titular.setIstoric("DA");
		else
			titular.setIstoric("NU");
		
		titular.setNrImobile(inputNumarImobileTitular.getText());
		titular.setPAD (inputPADTitular.getText());
		titular.setAsigurare(inputAsigurareTitular.getText());
		titular.setImpozit(inputImpozitTitular.getText());
		titular.setNrMasini(inputNumarMasiniTitular.getText());
		titular.setRCA(inputRCATitular.getText());
		titular.setCasco(inputCascoTitular.getText());
		titular.setImpozitMasina(inputImpozitMasinaTitular.getText());
		titular.setNumarCopii(inputNumarCopiiTitular.getText());
		titular.setNumarPersoaneIntretinere(inputNumarPersoaneIntretinereTitular.getText());
		
		titular.setTipCredit1 (inputTipCreditTitular1.getText());
		titular.setCreditor1 (inputCreditorTitular1.getText());
		titular.setSumaInitiala1 (inputSumaInitialaTitular1.getText());
		titular.setRataLunara1 (inputRataLunaraTitular1.getText());
		titular.setSoldCredit1 (inputSoldCreditTitular1.getText());
		titular.setDataContractare1(inputDataContractareTitular1.getText());
		titular.setDataScadenta1 (inputScadentaTitular1.getText());
		
		if(refinanteazaTitular1.isSelected())
			titular.setRefinantare1("DA");
		else
			titular.setRefinantare1("NU");
		
		if(intarzieriTitular1.isSelected())
			titular.setIntarziere1("DA");
		else
			titular.setIntarziere1("NU");
		
		if(inchideTitular1.isSelected())
			titular.setInchidere1("DA");
		else
			titular.setInchidere1("NU");
		
		titular.setTipCredit2 (inputTipCreditTitular2.getText());
		titular.setCreditor2 (inputCreditorTitular2.getText());
		titular.setSumaInitiala2 (inputSumaInitialaTitular2.getText());
		titular.setRataLunara2 (inputRataLunaraTitular2.getText());
		titular.setSoldCredit2 (inputSoldCreditTitular2.getText());
		titular.setDataContractare2 (inputDataContractareTitular2.getText());
		titular.setDataScadenta2 (inputScadentaTitular2.getText());
		
		if(refinanteazaTitular2.isSelected())
			titular.setRefinantare2("DA");
		else
			titular.setRefinantare2("NU");
		
		if(intarzieriTitular2.isSelected())
			titular.setIntarziere2("DA");
		else
			titular.setIntarziere2("NU");
		
		if(inchideTitular2.isSelected())
			titular.setInchidere2("DA");
		else
			titular.setInchidere2("NU");
		
		titular.setTipCredit3 (inputTipCreditTitular3.getText());
		titular.setCreditor3 (inputCreditorTitular3.getText());
		titular.setSumaInitiala3 (inputSumaInitialaTitular3.getText());
		titular.setRataLunara3 (inputRataLunaraTitular3.getText());
		titular.setSoldCredit3 (inputSoldCreditTitular3.getText());
		titular.setDataContractare3 (inputDataContractareTitular3.getText());
		titular.setDataScadenta3 (inputScadentaTitular3.getText());
		
		if(refinanteazaTitular3.isSelected())
			titular.setRefinantare3("DA");
		else
			titular.setRefinantare3("NU");
		
		if(intarzieriTitular3.isSelected())
			titular.setIntarziere3("DA");
		else
			titular.setIntarziere3("NU");
		
		if(inchideTitular3.isSelected())
			titular.setInchidere3("DA");
		else
			titular.setInchidere3("NU");
		
		titular.setTipCredit4 (inputTipCreditTitular4.getText());
		titular.setCreditor4 (inputCreditorTitular4.getText());
		titular.setSumaInitiala4(inputSumaInitialaTitular4.getText());
		titular.setRataLunara4 (inputRataLunaraTitular4.getText());
		titular.setSoldCredit4 (inputSoldCreditTitular4.getText());
		titular.setDataContractare4 (inputDataContractareTitular4.getText());
		titular.setDataScadenta4 (inputScadentaTitular4.getText());
		
		if(refinanteazaTitular4.isSelected())
			titular.setRefinantare4("DA");
		else
			titular.setRefinantare4("NU");
		
		if(intarzieriTitular4.isSelected())
			titular.setIntarziere4("DA");
		else
			titular.setIntarziere4("NU");
		
		if(inchideTitular4.isSelected())
			titular.setInchidere4("DA");
		else
			titular.setInchidere4("NU");
		
		titular.setAbonament(abonamentType[inputAbonamentTitular.getSelectedIndex()]);
		titular.setBroker(inputBroker.getText());
		titular.setUnit(inputUnit.getText());
		
		try
		{
			new File(outputPath).mkdirs();
		}
		
		catch(SecurityException securityException)
		{
			infoLabel.setText("Nu s-a putut creea folderul clientului, cel mai probabil nu aveti permisiunea de a salva in aceasta locatie");
		}
		
		String outputName = String.format("%s/%s%s.ser", outputPath, titular.getNume(),titular.getPrenume());
		
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(outputName)));
			output.writeObject(titular);
			
			try
			{
				if (output != null)
					output.close();
			}
			catch (IOException ioException)
			{
			}
			
		}
		catch (IOException ioException)
		{
			infoLabel.setText("Nu s-a putut creea fisierul titularului");
		}
		
	}
	
	
	public static void saveObjectCodebitor(String outputPath)
	{
		Client codebitor = new Client();
		
		codebitor.setNume(inputNumeCodebitor.getText());
		codebitor.setPrenume(inputPrenumeCodebitor.getText());
		codebitor.setCNP(inputCNPCodebitor.getText());
		codebitor.setEmail(inputEmailCodebitor.getText());
		codebitor.setID(IDType[IDCodebitor.getSelectedIndex()]);

		// id number and serie parsing
			String temp = inputIDCodebitor.getText();
			temp = temp.toUpperCase();
			String serie = "";
			
			if(temp.matches("[A-Z][A-Z] [0-9][0-9][0-9][0-9][0-9][0-9]"))
			{
				serie = temp.substring(0, 2);
				temp = temp.substring(3, temp.length());
			}
			else if(temp.matches("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]"))
			{	
				serie = temp.substring(0, 2);
				temp = temp.substring(2, temp.length());
			}
			codebitor.setNrID(temp); 
			codebitor.setSerie(serie);
		
		codebitor.setLaData(inputDataEliberareCodebitor.getText());
		codebitor.setEliberatDe(inputEliberatDeCodebitor.getText());
		codebitor.setAdresa(inputAdresaCodebitor.getText());
		codebitor.setDataNastere(inputDataNastereCodebitor.getText());
		codebitor.setLocalitateNastere(inputLocalitateNastereCodebitor.getText());
		codebitor.setResedinta(inputResedintaCodebitor.getText());
		codebitor.setSituatieLocativa(situatieLocativaType[inputSituatieLocativaCodebitor.getSelectedIndex()]);
		codebitor.setVechimeAdresa(inputVechimeAdresaCodebitor.getText());
		codebitor.setFunctie(inputFunctieCodebitor.getText());
		codebitor.setAngajator(inputAngajatorCodebitor.getText());
		codebitor.setVechimeTotala(inputVechimeTotalaCodebitor.getText());
		codebitor.setSituatieFamiliala(situatieFamilialaType[inputSituatieFamilialaCodebitor.getSelectedIndex()]);
		codebitor.setNumarMembriFamilie(inputNumarMembriFamilieCodebitor.getText());
		codebitor.setTelefonAngajator(inputTelAngajatorCodebitor.getText());
		codebitor.setTelefonFix(inputFixCodebitor.getText());
		codebitor.setTelefonMobil(inputMobilCodebitor.getText());
		codebitor.setNumeMama(inputNumeMamaCodebitor.getText());
		codebitor.setPrenumeTata(inputPrenumeTataCodebitor.getText());
		codebitor.setCNPSot(inputCNPSotCodebitor.getText());
		codebitor.setValabilPanaData(inputValabilPanaDataCodebitor.getText());
		codebitor.setNumeSot(inputNumeSotCodebitor.getText());
		
		if(masinaCodebitor.isSelected())
			codebitor.setMasina("DA");
		else
			codebitor.setMasina("NU");
		
		codebitor.setStudii(studiiType[inputStudiiCodebitor.getSelectedIndex()]);
		codebitor.setTipImobil (tipImobilType[inputTipImobilCodebitor.getSelectedIndex()]);
		codebitor.setTipVenit (venitType[inputTipVenitCodebitor1.getSelectedIndex()]);
		codebitor.setCUI(inputCUICodebitor.getText());
		codebitor.setNrAngajati(inputNrAngajatiCodebitor.getText());
		codebitor.setDataInfiintare(inputDataInfiintareCodebitor.getText());
		codebitor.setAdresaAngajator(inputAdresaAngajatorCodebitor.getText());
		codebitor.setDataAngajare(inputDataAngajareCodebitor.getText());
		codebitor.setDomeniu(inputDomeniuCodebitor.getText());
		codebitor.setCapital(capitalType[inputCapitalCodebitor.getSelectedIndex()]);
		codebitor.setCAEN (inputCAENCodebitor.getText());
		
		if(multinationalaCodebitor.isSelected())
			codebitor.setMultinationala("DA");
		else
			codebitor.setMultinationala("NU");
		
		codebitor.setTipSocietate (societateType[inputTipSocietateCodebitor.getSelectedIndex()]);
		codebitor.setProfesie(inputProfesieCodebitor.getText());
		codebitor.setTipFunctie(functieType[inputTipFunctieCodebitor.getSelectedIndex()]);
		codebitor.setVechimeUltimAngajator (inputVechimeUltimAngajatorCodebitor.getText());
		codebitor.setBonuriMasa(inputBonuriMasaCodebitor.getText());
		codebitor.setVenit3Luni(inputVenit3LuniCodebitor.getText());
		codebitor.setVenit6Luni(inputVenit6LuniCodebitor.getText());
		codebitor.setVenit12Luni(inputVenit12LuniCodebitor.getText());
		codebitor.setTipVenit3Luni(inputTipVenit3LuniCodebitor.getText());
		codebitor.setTipVenit6Luni(inputTipVenit6LuniCodebitor.getText());
		codebitor.setTipVenit12Luni(inputTipVenit12LuniCodebitor.getText());
		codebitor.setVenitCurent1 (inputVenitCurentCodebitor1.getText());
		codebitor.setVenitAnPrecedent1 (inputVenitAnPrecedentCodebitor1.getText());
		codebitor.setTipVenit1 (venitType[inputTipVenitCodebitor1.getSelectedIndex()]);
		codebitor.setVenitCurent2 (inputVenitCurentCodebitor2.getText());
		codebitor.setVenitAnPrecedent2 (inputVenitAnPrecedentCodebitor2.getText());
		codebitor.setTipVenit2 (venitType[inputTipVenitCodebitor2.getSelectedIndex()]);
		codebitor.setVenitCurent3 (inputVenitCurentCodebitor3.getText());
		codebitor.setVenitAnPrecedent3 (inputVenitAnPrecedentCodebitor3.getText());
		codebitor.setTipVenit3 (venitType[inputTipVenitCodebitor3.getSelectedIndex()]);
		codebitor.setContract(contractType[inputContractMuncaCodebitor.getSelectedIndex()]);
		codebitor.setDataExpirareContract(inputDataExpirareContractCodebitor.getText());
		
		if(marireCodebitor.isSelected())
			codebitor.setMarire("DA");
		else
			codebitor.setMarire("NU");
		
		if(conventieSalarialaCodebitor.isSelected())
			codebitor.setConventie("DA");
		else
			codebitor.setConventie("NU");
		
		codebitor.setBancaConventie (inputBancaConventieCodebitor.getText());
		codebitor.setConturi(inputConturiBanciCodebitor.getText());
		
		if(istoricCreditareCodebitor.isSelected())
			codebitor.setIstoric("DA");
		else
			codebitor.setIstoric("NU");
		
		codebitor.setNrImobile(inputNumarImobileCodebitor.getText());
		codebitor.setPAD (inputPADCodebitor.getText());
		codebitor.setAsigurare(inputAsigurareCodebitor.getText());
		codebitor.setImpozit(inputImpozitCodebitor.getText());
		codebitor.setNrMasini(inputNumarMasiniCodebitor.getText());
		codebitor.setRCA(inputRCACodebitor.getText());
		codebitor.setCasco(inputCascoCodebitor.getText());
		codebitor.setImpozitMasina(inputImpozitMasinaCodebitor.getText());
		codebitor.setNumarCopii(inputNumarCopiiCodebitor.getText());
		codebitor.setNumarPersoaneIntretinere(inputNumarPersoaneIntretinereCodebitor.getText());
		
		codebitor.setTipCredit1 (inputTipCreditCodebitor1.getText());
		codebitor.setCreditor1 (inputCreditorCodebitor1.getText());
		codebitor.setSumaInitiala1 (inputSumaInitialaCodebitor1.getText());
		codebitor.setRataLunara1 (inputRataLunaraCodebitor1.getText());
		codebitor.setSoldCredit1 (inputSoldCreditCodebitor1.getText());
		codebitor.setDataContractare1(inputDataContractareCodebitor1.getText());
		codebitor.setDataScadenta1 (inputScadentaCodebitor1.getText());
		
		if(refinanteazaCodebitor1.isSelected())
			codebitor.setRefinantare1("DA");
		else
			codebitor.setRefinantare1("NU");
		
		if(intarzieriCodebitor1.isSelected())
			codebitor.setIntarziere1("DA");
		else
			codebitor.setIntarziere1("NU");
		
		if(inchideCodebitor1.isSelected())
			codebitor.setInchidere1("DA");
		else
			codebitor.setInchidere1("NU");
		
		codebitor.setTipCredit2 (inputTipCreditCodebitor2.getText());
		codebitor.setCreditor2 (inputCreditorCodebitor2.getText());
		codebitor.setSumaInitiala2 (inputSumaInitialaCodebitor2.getText());
		codebitor.setRataLunara2 (inputRataLunaraCodebitor2.getText());
		codebitor.setSoldCredit2 (inputSoldCreditCodebitor2.getText());
		codebitor.setDataContractare2 (inputDataContractareCodebitor2.getText());
		codebitor.setDataScadenta2 (inputScadentaCodebitor2.getText());
		
		if(refinanteazaCodebitor2.isSelected())
			codebitor.setRefinantare2("DA");
		else
			codebitor.setRefinantare2("NU");
		
		if(intarzieriCodebitor2.isSelected())
			codebitor.setIntarziere2("DA");
		else
			codebitor.setIntarziere2("NU");
		
		if(inchideCodebitor2.isSelected())
			codebitor.setInchidere2("DA");
		else
			codebitor.setInchidere2("NU");
		
		codebitor.setTipCredit3 (inputTipCreditCodebitor3.getText());
		codebitor.setCreditor3 (inputCreditorCodebitor3.getText());
		codebitor.setSumaInitiala3 (inputSumaInitialaCodebitor3.getText());
		codebitor.setRataLunara3 (inputRataLunaraCodebitor3.getText());
		codebitor.setSoldCredit3 (inputSoldCreditCodebitor3.getText());
		codebitor.setDataContractare3 (inputDataContractareCodebitor3.getText());
		codebitor.setDataScadenta3 (inputScadentaCodebitor3.getText());
		
		if(refinanteazaCodebitor3.isSelected())
			codebitor.setRefinantare3("DA");
		else
			codebitor.setRefinantare3("NU");
		
		if(intarzieriCodebitor3.isSelected())
			codebitor.setIntarziere3("DA");
		else
			codebitor.setIntarziere3("NU");
		
		if(inchideCodebitor3.isSelected())
			codebitor.setInchidere3("DA");
		else
			codebitor.setInchidere3("NU");
		
		codebitor.setTipCredit4 (inputTipCreditCodebitor4.getText());
		codebitor.setCreditor4 (inputCreditorCodebitor4.getText());
		codebitor.setSumaInitiala4(inputSumaInitialaCodebitor4.getText());
		codebitor.setRataLunara4 (inputRataLunaraCodebitor4.getText());
		codebitor.setSoldCredit4 (inputSoldCreditCodebitor4.getText());
		codebitor.setDataContractare4 (inputDataContractareCodebitor4.getText());
		codebitor.setDataScadenta4 (inputScadentaCodebitor4.getText());
		
		if(refinanteazaCodebitor4.isSelected())
			codebitor.setRefinantare4("DA");
		else
			codebitor.setRefinantare4("NU");
		
		if(intarzieriCodebitor4.isSelected())
			codebitor.setIntarziere4("DA");
		else
			codebitor.setIntarziere4("NU");
		
		if(inchideCodebitor4.isSelected())
			codebitor.setInchidere4("DA");
		else
			codebitor.setInchidere4("NU");
		
		codebitor.setAbonament(abonamentType[inputAbonamentCodebitor.getSelectedIndex()]);
		codebitor.setBroker(inputBroker.getText());
		codebitor.setUnit(inputUnit.getText());
		
		try
		{
			new File(outputPath).mkdirs();
		}
		
		catch(SecurityException securityException)
		{
			infoLabel.setText("Nu s-a putut creea folderul clientului, cel mai probabil nu aveti permisiunea de a salva in aceasta locatie");
		}
		
		String outputName = String.format("%s/%s%s.ser", outputPath, codebitor.getNume(),codebitor.getPrenume());
		
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(outputName)));
			output.writeObject(codebitor);
			
			try
			{
				if (output != null)
					output.close();
			}
			catch (IOException ioException)
			{
			}
			
		}
		catch (IOException ioException)
		{
			infoLabel.setText("Nu s-a putut creea fisierul titularului");
		}
		
	}
	
	
	public static void openObjectTitular(Path object)
	{
		ObjectInputStream input = null;
		try // open file
		{
			input = new ObjectInputStream(Files.newInputStream(object));
		}
		catch (IOException ioException)
		{
			infoLabel.setText("Nu s-a putut deschide fisierul dorit");
		}
		
		Client titular = null;
		
		try
		{
			titular = (Client) input.readObject(); 
			input.close();
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			infoLabel.setText("Fisierul nu contine informatii valabile");
		}
		catch (IOException ioException)
		{
			infoLabel.setText("Nu s-a putut deschide fisierul dorit");
		}
		
		
		inputNumeTitular.setText(titular.getNume());
		inputPrenumeTitular.setText(titular.getPrenume());
		inputCNPTitular.setText(titular.getCNP());
		inputEmailTitular.setText(titular.getEmail());
		inputIDTitular.setText(String.format("%s %s", titular.getSerie(), titular.getNrID()));
		
		for(int i = 0; i < IDType.length; i ++)
			if(IDType[i].matches(titular.getID()))
				IDTitular.setSelectedIndex(i);
		
		inputDataEliberareTitular.setText(titular.getLaData());
		inputEliberatDeTitular.setText(titular.getEliberatDe());
		inputAdresaTitular.setText(titular.getAdresa());
		inputDataNastereTitular.setText(titular.getDataNastere());
		inputLocalitateNastereTitular.setText(titular.getLocalitateNastere());
		inputResedintaTitular.setText(titular.getResedinta());
		
		for(int i = 0; i < situatieLocativaType.length; i ++)
			if(situatieLocativaType[i].matches(titular.getSituatieLocativa()))
				inputSituatieLocativaTitular.setSelectedIndex(i);
		
		
		inputVechimeAdresaTitular.setText(titular.getVechimeAdresa());
		inputFunctieTitular.setText(titular.getFunctie());
		inputAngajatorTitular.setText(titular.getAngajator());
		inputVechimeTotalaTitular.setText(titular.getVechimeTotala());
		
		for(int i = 0; i < situatieFamilialaType.length; i ++)
			if(situatieFamilialaType[i].matches(titular.getSituatieFamiliala()))
				inputSituatieFamilialaTitular.setSelectedIndex(i);

		inputNumarMembriFamilieTitular.setText(titular.getNumarMembriFamilie());
		inputTelAngajatorTitular.setText(titular.getTelefonAngajator());
		inputFixTitular.setText(titular.getTelefonFix());
		inputMobilTitular.setText(titular.getTelefonMobil());
		inputNumeMamaTitular.setText(titular.getNumeMama());
		inputPrenumeTataTitular.setText(titular.getPrenumeTata());
		inputCNPSotTitular.setText(titular.getCNPSot());
		inputValabilPanaDataTitular.setText(titular.getValabilPanaData());
		inputNumeSotTitular.setText(titular.getNumeSot());
		
		if(titular.getMasina().matches("DA"))
			masinaTitular.setSelected(true);
		else
			masinaTitular.setSelected(false);
		
		for(int i = 0; i < studiiType.length; i ++)
			if(studiiType[i].matches(titular.getStudii()))
				inputStudiiTitular.setSelectedIndex(i);

			
		for(int i = 0; i < tipImobilType.length; i ++)
			if(tipImobilType[i].matches(titular.getTipImobil()))
				inputTipImobilTitular.setSelectedIndex(i);
				
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(titular.getTipVenit1()))
				inputTipVenitTitular1.setSelectedIndex(i);
		
		inputCUITitular.setText(titular.getCUI());
		inputNrAngajatiTitular.setText(titular.getNrAngajati());
		inputDataInfiintareTitular.setText(titular.getDataInfiintare());
		inputAdresaAngajatorTitular.setText(titular.getAdresaAngajator());
		inputDataAngajareTitular.setText(titular.getDataAngajare());
		inputDomeniuTitular.setText(titular.getDomeniu());
		
	
		for(int i = 0; i < capitalType.length; i ++)
			if(capitalType[i].matches(titular.getCapital()))
				inputCapitalTitular.setSelectedIndex(i);
		
		inputCAENTitular.setText(titular.getCAEN ());
		
		
		if(titular.getMultinationala().matches("DA"))
			multinationalaTitular.setSelected(true);
		else
			multinationalaTitular.setSelected(false);
		
				
		for(int i = 0; i < societateType.length; i ++)
			if(societateType[i].matches(titular.getTipSocietate()))
				inputTipSocietateTitular.setSelectedIndex(i);

		inputProfesieTitular.setText(titular.getProfesie());
		
		for(int i = 0; i < functieType.length; i ++)
			if(functieType[i].matches(titular.getTipFunctie()))
				inputTipFunctieTitular.setSelectedIndex(i);
		
		inputVechimeUltimAngajatorTitular.setText(titular.getVechimeUltimAngajator ());
		inputBonuriMasaTitular.setText(titular.getBonuriMasa());
		inputVenit3LuniTitular.setText(titular.getVenit3Luni());
		inputVenit6LuniTitular.setText(titular.getVenit6Luni());
		inputVenit12LuniTitular.setText(titular.getVenit12Luni());
		inputTipVenit3LuniTitular.setText(titular.getTipVenit3Luni());
		inputTipVenit6LuniTitular.setText(titular.getTipVenit6Luni());
		inputTipVenit12LuniTitular.setText(titular.getTipVenit12Luni());
		inputVenitCurentTitular1.setText(titular.getVenitCurent1 ());
		inputVenitAnPrecedentTitular1.setText(titular.getVenitAnPrecedent1 ());
		
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(titular.getTipVenit1()))
				inputTipVenitTitular1.setSelectedIndex(i);
		
		inputVenitCurentTitular2.setText(titular.getVenitCurent2 ());
		inputVenitAnPrecedentTitular2.setText(titular.getVenitAnPrecedent2 ());
		
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(titular.getTipVenit2()))
				inputTipVenitTitular2.setSelectedIndex(i);
		
		inputVenitCurentTitular3.setText(titular.getVenitCurent3 ());
		inputVenitAnPrecedentTitular3.setText(titular.getVenitAnPrecedent3 ());
				
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(titular.getTipVenit3()))
				inputTipVenitTitular3.setSelectedIndex(i);

		for(int i = 0; i < contractType.length; i ++)
			if(contractType[i].matches(titular.getContract()))
				inputContractMuncaTitular.setSelectedIndex(i);
		
		inputDataExpirareContractTitular.setText(titular.getDataExpirareContract());
		
		if(titular.getMarire().matches("DA"))
			marireTitular.setSelected(true);
		else
			marireTitular.setSelected(false);
	
	
		if(titular.getConventie().matches("DA"))
			conventieSalarialaTitular.setSelected(true);
		else
			conventieSalarialaTitular.setSelected(false);
		
		inputBancaConventieTitular.setText(titular.getBancaConventie ());
		inputConturiBanciTitular.setText(titular.getConturi());
		
		
		if(titular.getIstoric().matches("DA"))
		{
			istoricCreditareTitular.setSelected(true);
			inputTipCreditTitular1.setEnabled(true);
			inputTipCreditTitular1.setBackground(Color.WHITE);
										
			inputCreditorTitular1.setEnabled(true);
			inputCreditorTitular1.setBackground(Color.WHITE);
															
			inputSumaInitialaTitular1.setEnabled(true);
			inputSumaInitialaTitular1.setBackground(Color.WHITE);
			
			inputRataLunaraTitular1.setEnabled(true);
			inputRataLunaraTitular1.setBackground(Color.WHITE);
										
			inputSoldCreditTitular1.setEnabled(true);
			inputSoldCreditTitular1.setBackground(Color.WHITE);
										
			inputDataContractareTitular1.setEnabled(true);
			inputDataContractareTitular1.setBackground(Color.WHITE);
			
			inputScadentaTitular1.setEnabled(true);
			inputScadentaTitular1.setBackground(Color.WHITE);
			
			refinanteazaTitular1.setEnabled(true);
			intarzieriTitular1.setEnabled(true);
			inchideTitular1.setEnabled(true);
		
			// row21
			inputTipCreditTitular2.setEnabled(true);
			inputTipCreditTitular2.setBackground(Color.WHITE);

			inputCreditorTitular2.setEnabled(true);
			inputCreditorTitular2.setBackground(Color.WHITE);

			inputSumaInitialaTitular2.setEnabled(true);
			inputSumaInitialaTitular2.setBackground(Color.WHITE);

			inputRataLunaraTitular2.setEnabled(true);
			inputRataLunaraTitular2.setBackground(Color.WHITE);

			inputSoldCreditTitular2.setEnabled(true);
			inputSoldCreditTitular2.setBackground(Color.WHITE);

			inputDataContractareTitular2.setEnabled(true);
			inputDataContractareTitular2.setBackground(Color.WHITE);

			inputScadentaTitular2.setEnabled(true);
			inputScadentaTitular2.setBackground(Color.WHITE);

			refinanteazaTitular2.setEnabled(true);
			intarzieriTitular2.setEnabled(true);
			inchideTitular2.setEnabled(true);
			
			// row22

			inputTipCreditTitular3.setEnabled(true);
			inputTipCreditTitular3.setBackground(Color.WHITE);

			inputCreditorTitular3.setEnabled(true);
			inputCreditorTitular3.setBackground(Color.WHITE);

			inputSumaInitialaTitular3.setEnabled(true);
			inputSumaInitialaTitular3.setBackground(Color.WHITE);

			inputRataLunaraTitular3.setEnabled(true);
			inputRataLunaraTitular3.setBackground(Color.WHITE);

			inputSoldCreditTitular3.setEnabled(true);
			inputSoldCreditTitular3.setBackground(Color.WHITE);

			inputDataContractareTitular3.setEnabled(true);
			inputDataContractareTitular3.setBackground(Color.WHITE);

			inputScadentaTitular3.setEnabled(true);
			inputScadentaTitular3.setBackground(Color.WHITE);

			refinanteazaTitular3.setEnabled(true);
			intarzieriTitular3.setEnabled(true);
			inchideTitular3.setEnabled(true);
				
			// row23
			inputTipCreditTitular4.setEnabled(true);
			inputTipCreditTitular4.setBackground(Color.WHITE);

			inputCreditorTitular4.setEnabled(true);
			inputCreditorTitular4.setBackground(Color.WHITE);

			inputSumaInitialaTitular4.setEnabled(true);
			inputSumaInitialaTitular4.setBackground(Color.WHITE);

			inputRataLunaraTitular4.setEnabled(true);
			inputRataLunaraTitular4.setBackground(Color.WHITE);

			inputSoldCreditTitular4.setEnabled(true);
			inputSoldCreditTitular4.setBackground(Color.WHITE);

			inputDataContractareTitular4.setEnabled(true);
			inputDataContractareTitular4.setBackground(Color.WHITE);

			inputScadentaTitular4.setEnabled(true);
			inputScadentaTitular4.setBackground(Color.WHITE);

			refinanteazaTitular4.setEnabled(true);
			intarzieriTitular4.setEnabled(true);
			inchideTitular4.setEnabled(true);
		}
		else
		{
			istoricCreditareTitular.setSelected(false);
			// row20
			inputTipCreditTitular1.setEnabled(false);
            inputTipCreditTitular1.setBackground(Color.LIGHT_GRAY);
                        	
            inputCreditorTitular1.setEnabled(false);
            inputCreditorTitular1.setBackground(Color.LIGHT_GRAY);
                                    
            inputSumaInitialaTitular1.setEnabled(false);
            inputSumaInitialaTitular1.setBackground(Color.LIGHT_GRAY);
            
            inputRataLunaraTitular1.setEnabled(false);
            inputRataLunaraTitular1.setBackground(Color.LIGHT_GRAY);
                        	
            inputSoldCreditTitular1.setEnabled(false);
            inputSoldCreditTitular1.setBackground(Color.LIGHT_GRAY);
                        	
            inputDataContractareTitular1.setEnabled(false);
            inputDataContractareTitular1.setBackground(Color.LIGHT_GRAY);
            
            inputScadentaTitular1.setEnabled(false);
            inputScadentaTitular1.setBackground(Color.LIGHT_GRAY);
            
            refinanteazaTitular1.setEnabled(false);
            intarzieriTitular1.setEnabled(false);
            inchideTitular1.setEnabled(false);
					
            // row21
            inputTipCreditTitular2.setEnabled(false);
            inputTipCreditTitular2.setBackground(Color.LIGHT_GRAY);

            inputCreditorTitular2.setEnabled(false);
            inputCreditorTitular2.setBackground(Color.LIGHT_GRAY);

            inputSumaInitialaTitular2.setEnabled(false);
            inputSumaInitialaTitular2.setBackground(Color.LIGHT_GRAY);

            inputRataLunaraTitular2.setEnabled(false);
            inputRataLunaraTitular2.setBackground(Color.LIGHT_GRAY);

            inputSoldCreditTitular2.setEnabled(false);
            inputSoldCreditTitular2.setBackground(Color.LIGHT_GRAY);

            inputDataContractareTitular2.setEnabled(false);
            inputDataContractareTitular2.setBackground(Color.LIGHT_GRAY);

            inputScadentaTitular2.setEnabled(false);
            inputScadentaTitular2.setBackground(Color.LIGHT_GRAY);

            refinanteazaTitular2.setEnabled(false);
            intarzieriTitular2.setEnabled(false);
            inchideTitular2.setEnabled(false);
            
            // row22

            inputTipCreditTitular3.setEnabled(false);
            inputTipCreditTitular3.setBackground(Color.LIGHT_GRAY);

            inputCreditorTitular3.setEnabled(false);
            inputCreditorTitular3.setBackground(Color.LIGHT_GRAY);

            inputSumaInitialaTitular3.setEnabled(false);
            inputSumaInitialaTitular3.setBackground(Color.LIGHT_GRAY);

            inputRataLunaraTitular3.setEnabled(false);
            inputRataLunaraTitular3.setBackground(Color.LIGHT_GRAY);

            inputSoldCreditTitular3.setEnabled(false);
            inputSoldCreditTitular3.setBackground(Color.LIGHT_GRAY);

            inputDataContractareTitular3.setEnabled(false);
            inputDataContractareTitular3.setBackground(Color.LIGHT_GRAY);

            inputScadentaTitular3.setEnabled(false);
            inputScadentaTitular3.setBackground(Color.LIGHT_GRAY);

            refinanteazaTitular3.setEnabled(false);
            intarzieriTitular3.setEnabled(false);
            inchideTitular3.setEnabled(false);
            	
            // row23
            inputTipCreditTitular4.setEnabled(false);
            inputTipCreditTitular4.setBackground(Color.LIGHT_GRAY);

            inputCreditorTitular4.setEnabled(false);
            inputCreditorTitular4.setBackground(Color.LIGHT_GRAY);

            inputSumaInitialaTitular4.setEnabled(false);
            inputSumaInitialaTitular4.setBackground(Color.LIGHT_GRAY);

            inputRataLunaraTitular4.setEnabled(false);
            inputRataLunaraTitular4.setBackground(Color.LIGHT_GRAY);

            inputSoldCreditTitular4.setEnabled(false);
            inputSoldCreditTitular4.setBackground(Color.LIGHT_GRAY);

            inputDataContractareTitular4.setEnabled(false);
            inputDataContractareTitular4.setBackground(Color.LIGHT_GRAY);

            inputScadentaTitular4.setEnabled(false);
            inputScadentaTitular4.setBackground(Color.LIGHT_GRAY);

            refinanteazaTitular4.setEnabled(false);
            intarzieriTitular4.setEnabled(false);
			inchideTitular4.setEnabled(false);
		}
		
		
		inputNumarImobileTitular.setText(titular.getNrImobile());
		inputPADTitular.setText(titular.getPAD ());
		inputAsigurareTitular.setText(titular.getAsigurare());
		inputImpozitTitular.setText(titular.getImpozit());
		inputNumarMasiniTitular.setText(titular.getNrMasini());
		inputRCATitular.setText(titular.getRCA());
		inputCascoTitular.setText(titular.getCasco());
		inputImpozitMasinaTitular.setText(titular.getImpozitMasina());
		inputNumarCopiiTitular.setText(titular.getNumarCopii());
		inputNumarPersoaneIntretinereTitular.setText(titular.getNumarPersoaneIntretinere());
		
		inputTipCreditTitular1.setText(titular.getTipCredit1());
		inputCreditorTitular1.setText(titular.getCreditor1());
		inputSumaInitialaTitular1.setText(titular.getSumaInitiala1());
		inputRataLunaraTitular1.setText(titular.getRataLunara1());
		inputSoldCreditTitular1.setText(titular.getSoldCredit1 ());
		inputDataContractareTitular1.setText(titular.getDataContractare1());
		inputScadentaTitular1.setText(titular.getDataScadenta1());
		
		if(titular.getRefinantare1().matches("DA"))
			refinanteazaTitular1.setSelected(true);
		else
			refinanteazaTitular1.setSelected(false);
		
		
		if(titular.getIntarziere1().matches("DA"))
			intarzieriTitular1.setSelected(true);
		else
			intarzieriTitular1.setSelected(false);
		
		if(titular.getInchidere1().matches("DA"))
			inchideTitular1.setSelected(true);
		else
			inchideTitular1.setSelected(false);

		inputTipCreditTitular2.setText(titular.getTipCredit2());
		inputCreditorTitular2.setText(titular.getCreditor2());
		inputSumaInitialaTitular2.setText(titular.getSumaInitiala2());
		inputRataLunaraTitular2.setText(titular.getRataLunara2());
		inputSoldCreditTitular2.setText(titular.getSoldCredit2 ());
		inputDataContractareTitular2.setText(titular.getDataContractare2());
		inputScadentaTitular2.setText(titular.getDataScadenta2());
		
		if(titular.getRefinantare2().matches("DA"))
			refinanteazaTitular2.setSelected(true);
		else
			refinanteazaTitular2.setSelected(false);
		
		
		if(titular.getIntarziere2().matches("DA"))
			intarzieriTitular2.setSelected(true);
		else
			intarzieriTitular2.setSelected(false);
		
		if(titular.getInchidere2().matches("DA"))
			inchideTitular2.setSelected(true);
		else
			inchideTitular2.setSelected(false);
		
		inputTipCreditTitular3.setText(titular.getTipCredit3());
		inputCreditorTitular3.setText(titular.getCreditor3());
		inputSumaInitialaTitular3.setText(titular.getSumaInitiala3());
		inputRataLunaraTitular3.setText(titular.getRataLunara3());
		inputSoldCreditTitular3.setText(titular.getSoldCredit3 ());
		inputDataContractareTitular3.setText(titular.getDataContractare3());
		inputScadentaTitular3.setText(titular.getDataScadenta3());
		
		if(titular.getRefinantare3().matches("DA"))
			refinanteazaTitular3.setSelected(true);
		else
			refinanteazaTitular3.setSelected(false);
		
		
		if(titular.getIntarziere3().matches("DA"))
			intarzieriTitular3.setSelected(true);
		else
			intarzieriTitular3.setSelected(false);
		
		if(titular.getInchidere3().matches("DA"))
			inchideTitular3.setSelected(true);
		else
			inchideTitular3.setSelected(false);
		
		inputTipCreditTitular4.setText(titular.getTipCredit4());
		inputCreditorTitular4.setText(titular.getCreditor4());
		inputSumaInitialaTitular4.setText(titular.getSumaInitiala4());
		inputRataLunaraTitular4.setText(titular.getRataLunara4());
		inputSoldCreditTitular4.setText(titular.getSoldCredit4 ());
		inputDataContractareTitular4.setText(titular.getDataContractare4());
		inputScadentaTitular4.setText(titular.getDataScadenta4());
		
		if(titular.getRefinantare4().matches("DA"))
			refinanteazaTitular4.setSelected(true);
		else
			refinanteazaTitular4.setSelected(false);
		
		
		if(titular.getIntarziere4().matches("DA"))
			intarzieriTitular4.setSelected(true);
		else
			intarzieriTitular4.setSelected(false);
		
		if(titular.getInchidere4().matches("DA"))
			inchideTitular4.setSelected(true);
		else
			inchideTitular4.setSelected(false);
		
		
		for(int i = 0; i < abonamentType.length; i ++)
			if(abonamentType[i].matches(titular.getAbonament()))
				inputAbonamentTitular.setSelectedIndex(i);

		inputBroker.setText(titular.getBroker());
		inputUnit.setText(titular.getUnit());
	
		
	}
	
	
	public static void openObjectCodebitor(Path object)
	{
		ObjectInputStream input = null;
		try // open file
		{
			input = new ObjectInputStream(Files.newInputStream(object));
		}
		catch (IOException ioException)
		{
			infoLabel.setText("Nu s-a putut deschide fisierul dorit");
		}
		
		Client codebitor = null;
		
		try
		{
			codebitor = (Client) input.readObject(); 
			input.close();
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			infoLabel.setText("Fisierul nu contine informatii valabile");
		}
		catch (IOException ioException)
		{
			infoLabel.setText("Nu s-a putut deschide fisierul dorit");
		}
		
		
		inputNumeCodebitor.setText(codebitor.getNume());
		inputPrenumeCodebitor.setText(codebitor.getPrenume());
		inputCNPCodebitor.setText(codebitor.getCNP());
		inputEmailCodebitor.setText(codebitor.getEmail());
		inputIDCodebitor.setText(String.format("%s %s", codebitor.getSerie(), codebitor.getNrID()));
		
		for(int i = 0; i < IDType.length; i ++)
			if(IDType[i].matches(codebitor.getID()))
				IDCodebitor.setSelectedIndex(i);
		
		inputDataEliberareCodebitor.setText(codebitor.getLaData());
		inputEliberatDeCodebitor.setText(codebitor.getEliberatDe());
		inputAdresaCodebitor.setText(codebitor.getAdresa());
		inputDataNastereCodebitor.setText(codebitor.getDataNastere());
		inputLocalitateNastereCodebitor.setText(codebitor.getLocalitateNastere());
		inputResedintaCodebitor.setText(codebitor.getResedinta());
		
		for(int i = 0; i < situatieLocativaType.length; i ++)
			if(situatieLocativaType[i].matches(codebitor.getSituatieLocativa()))
				inputSituatieLocativaCodebitor.setSelectedIndex(i);
		
		
		inputVechimeAdresaCodebitor.setText(codebitor.getVechimeAdresa());
		inputFunctieCodebitor.setText(codebitor.getFunctie());
		inputAngajatorCodebitor.setText(codebitor.getAngajator());
		inputVechimeTotalaCodebitor.setText(codebitor.getVechimeTotala());
		
		for(int i = 0; i < situatieFamilialaType.length; i ++)
			if(situatieFamilialaType[i].matches(codebitor.getSituatieFamiliala()))
				inputSituatieFamilialaCodebitor.setSelectedIndex(i);

		inputNumarMembriFamilieCodebitor.setText(codebitor.getNumarMembriFamilie());
		inputTelAngajatorCodebitor.setText(codebitor.getTelefonAngajator());
		inputFixCodebitor.setText(codebitor.getTelefonFix());
		inputMobilCodebitor.setText(codebitor.getTelefonMobil());
		inputNumeMamaCodebitor.setText(codebitor.getNumeMama());
		inputPrenumeTataCodebitor.setText(codebitor.getPrenumeTata());
		inputCNPSotCodebitor.setText(codebitor.getCNPSot());
		inputValabilPanaDataCodebitor.setText(codebitor.getValabilPanaData());
		inputNumeSotCodebitor.setText(codebitor.getNumeSot());
		
		if(codebitor.getMasina().matches("DA"))
			masinaCodebitor.setSelected(true);
		else
			masinaCodebitor.setSelected(false);
		
		for(int i = 0; i < studiiType.length; i ++)
			if(studiiType[i].matches(codebitor.getStudii()))
				inputStudiiCodebitor.setSelectedIndex(i);

			
		for(int i = 0; i < tipImobilType.length; i ++)
			if(tipImobilType[i].matches(codebitor.getTipImobil()))
				inputTipImobilCodebitor.setSelectedIndex(i);
				
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(codebitor.getTipVenit1()))
				inputTipVenitCodebitor1.setSelectedIndex(i);
		
		inputCUICodebitor.setText(codebitor.getCUI());
		inputNrAngajatiCodebitor.setText(codebitor.getNrAngajati());
		inputDataInfiintareCodebitor.setText(codebitor.getDataInfiintare());
		inputAdresaAngajatorCodebitor.setText(codebitor.getAdresaAngajator());
		inputDataAngajareCodebitor.setText(codebitor.getDataAngajare());
		inputDomeniuCodebitor.setText(codebitor.getDomeniu());
		
	
		for(int i = 0; i < capitalType.length; i ++)
			if(capitalType[i].matches(codebitor.getCapital()))
				inputCapitalCodebitor.setSelectedIndex(i);
		
		inputCAENCodebitor.setText(codebitor.getCAEN ());
		
		
		if(codebitor.getMultinationala().matches("DA"))
			multinationalaCodebitor.setSelected(true);
		else
			multinationalaCodebitor.setSelected(false);
		
				
		for(int i = 0; i < societateType.length; i ++)
			if(societateType[i].matches(codebitor.getTipSocietate()))
				inputTipSocietateCodebitor.setSelectedIndex(i);

		inputProfesieCodebitor.setText(codebitor.getProfesie());
		
		for(int i = 0; i < functieType.length; i ++)
			if(functieType[i].matches(codebitor.getTipFunctie()))
				inputTipFunctieCodebitor.setSelectedIndex(i);
		
		inputVechimeUltimAngajatorCodebitor.setText(codebitor.getVechimeUltimAngajator ());
		inputBonuriMasaCodebitor.setText(codebitor.getBonuriMasa());
		inputVenit3LuniCodebitor.setText(codebitor.getVenit3Luni());
		inputVenit6LuniCodebitor.setText(codebitor.getVenit6Luni());
		inputVenit12LuniCodebitor.setText(codebitor.getVenit12Luni());
		inputTipVenit3LuniCodebitor.setText(codebitor.getTipVenit3Luni());
		inputTipVenit6LuniCodebitor.setText(codebitor.getTipVenit6Luni());
		inputTipVenit12LuniCodebitor.setText(codebitor.getTipVenit12Luni());
		inputVenitCurentCodebitor1.setText(codebitor.getVenitCurent1 ());
		inputVenitAnPrecedentCodebitor1.setText(codebitor.getVenitAnPrecedent1 ());
		
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(codebitor.getTipVenit1()))
				inputTipVenitCodebitor1.setSelectedIndex(i);
		
		inputVenitCurentCodebitor2.setText(codebitor.getVenitCurent2 ());
		inputVenitAnPrecedentCodebitor2.setText(codebitor.getVenitAnPrecedent2 ());
		
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(codebitor.getTipVenit2()))
				inputTipVenitCodebitor2.setSelectedIndex(i);
		
		inputVenitCurentCodebitor3.setText(codebitor.getVenitCurent3 ());
		inputVenitAnPrecedentCodebitor3.setText(codebitor.getVenitAnPrecedent3 ());
				
		for(int i = 0; i < venitType.length; i ++)
			if(venitType[i].matches(codebitor.getTipVenit3()))
				inputTipVenitCodebitor3.setSelectedIndex(i);

		for(int i = 0; i < contractType.length; i ++)
			if(contractType[i].matches(codebitor.getContract()))
				inputContractMuncaCodebitor.setSelectedIndex(i);
		
		inputDataExpirareContractCodebitor.setText(codebitor.getDataExpirareContract());
		
		if(codebitor.getMarire().matches("DA"))
			marireCodebitor.setSelected(true);
		else
			marireCodebitor.setSelected(false);
	
	
		if(codebitor.getConventie().matches("DA"))
			conventieSalarialaCodebitor.setSelected(true);
		else
			conventieSalarialaCodebitor.setSelected(false);
		
		inputBancaConventieCodebitor.setText(codebitor.getBancaConventie ());
		inputConturiBanciCodebitor.setText(codebitor.getConturi());
		
		
		if(codebitor.getIstoric().matches("DA"))
		{
			istoricCreditareCodebitor.setSelected(true);
			inputTipCreditCodebitor1.setEnabled(true);
			inputTipCreditCodebitor1.setBackground(Color.WHITE);
										
			inputCreditorCodebitor1.setEnabled(true);
			inputCreditorCodebitor1.setBackground(Color.WHITE);
															
			inputSumaInitialaCodebitor1.setEnabled(true);
			inputSumaInitialaCodebitor1.setBackground(Color.WHITE);
			
			inputRataLunaraCodebitor1.setEnabled(true);
			inputRataLunaraCodebitor1.setBackground(Color.WHITE);
										
			inputSoldCreditCodebitor1.setEnabled(true);
			inputSoldCreditCodebitor1.setBackground(Color.WHITE);
										
			inputDataContractareCodebitor1.setEnabled(true);
			inputDataContractareCodebitor1.setBackground(Color.WHITE);
			
			inputScadentaCodebitor1.setEnabled(true);
			inputScadentaCodebitor1.setBackground(Color.WHITE);
			
			refinanteazaCodebitor1.setEnabled(true);
			intarzieriCodebitor1.setEnabled(true);
			inchideCodebitor1.setEnabled(true);
		
			// row21
			inputTipCreditCodebitor2.setEnabled(true);
			inputTipCreditCodebitor2.setBackground(Color.WHITE);

			inputCreditorCodebitor2.setEnabled(true);
			inputCreditorCodebitor2.setBackground(Color.WHITE);

			inputSumaInitialaCodebitor2.setEnabled(true);
			inputSumaInitialaCodebitor2.setBackground(Color.WHITE);

			inputRataLunaraCodebitor2.setEnabled(true);
			inputRataLunaraCodebitor2.setBackground(Color.WHITE);

			inputSoldCreditCodebitor2.setEnabled(true);
			inputSoldCreditCodebitor2.setBackground(Color.WHITE);

			inputDataContractareCodebitor2.setEnabled(true);
			inputDataContractareCodebitor2.setBackground(Color.WHITE);

			inputScadentaCodebitor2.setEnabled(true);
			inputScadentaCodebitor2.setBackground(Color.WHITE);

			refinanteazaCodebitor2.setEnabled(true);
			intarzieriCodebitor2.setEnabled(true);
			inchideCodebitor2.setEnabled(true);
			
			// row22

			inputTipCreditCodebitor3.setEnabled(true);
			inputTipCreditCodebitor3.setBackground(Color.WHITE);

			inputCreditorCodebitor3.setEnabled(true);
			inputCreditorCodebitor3.setBackground(Color.WHITE);

			inputSumaInitialaCodebitor3.setEnabled(true);
			inputSumaInitialaCodebitor3.setBackground(Color.WHITE);

			inputRataLunaraCodebitor3.setEnabled(true);
			inputRataLunaraCodebitor3.setBackground(Color.WHITE);

			inputSoldCreditCodebitor3.setEnabled(true);
			inputSoldCreditCodebitor3.setBackground(Color.WHITE);

			inputDataContractareCodebitor3.setEnabled(true);
			inputDataContractareCodebitor3.setBackground(Color.WHITE);

			inputScadentaCodebitor3.setEnabled(true);
			inputScadentaCodebitor3.setBackground(Color.WHITE);

			refinanteazaCodebitor3.setEnabled(true);
			intarzieriCodebitor3.setEnabled(true);
			inchideCodebitor3.setEnabled(true);
				
			// row23
			inputTipCreditCodebitor4.setEnabled(true);
			inputTipCreditCodebitor4.setBackground(Color.WHITE);

			inputCreditorCodebitor4.setEnabled(true);
			inputCreditorCodebitor4.setBackground(Color.WHITE);

			inputSumaInitialaCodebitor4.setEnabled(true);
			inputSumaInitialaCodebitor4.setBackground(Color.WHITE);

			inputRataLunaraCodebitor4.setEnabled(true);
			inputRataLunaraCodebitor4.setBackground(Color.WHITE);

			inputSoldCreditCodebitor4.setEnabled(true);
			inputSoldCreditCodebitor4.setBackground(Color.WHITE);

			inputDataContractareCodebitor4.setEnabled(true);
			inputDataContractareCodebitor4.setBackground(Color.WHITE);

			inputScadentaCodebitor4.setEnabled(true);
			inputScadentaCodebitor4.setBackground(Color.WHITE);

			refinanteazaCodebitor4.setEnabled(true);
			intarzieriCodebitor4.setEnabled(true);
			inchideCodebitor4.setEnabled(true);
		}
		else
		{
			istoricCreditareCodebitor.setSelected(false);
			// row20
			inputTipCreditCodebitor1.setEnabled(false);
            inputTipCreditCodebitor1.setBackground(Color.LIGHT_GRAY);
                        	
            inputCreditorCodebitor1.setEnabled(false);
            inputCreditorCodebitor1.setBackground(Color.LIGHT_GRAY);
                                    
            inputSumaInitialaCodebitor1.setEnabled(false);
            inputSumaInitialaCodebitor1.setBackground(Color.LIGHT_GRAY);
            
            inputRataLunaraCodebitor1.setEnabled(false);
            inputRataLunaraCodebitor1.setBackground(Color.LIGHT_GRAY);
                        	
            inputSoldCreditCodebitor1.setEnabled(false);
            inputSoldCreditCodebitor1.setBackground(Color.LIGHT_GRAY);
                        	
            inputDataContractareCodebitor1.setEnabled(false);
            inputDataContractareCodebitor1.setBackground(Color.LIGHT_GRAY);
            
            inputScadentaCodebitor1.setEnabled(false);
            inputScadentaCodebitor1.setBackground(Color.LIGHT_GRAY);
            
            refinanteazaCodebitor1.setEnabled(false);
            intarzieriCodebitor1.setEnabled(false);
            inchideCodebitor1.setEnabled(false);
					
            // row21
            inputTipCreditCodebitor2.setEnabled(false);
            inputTipCreditCodebitor2.setBackground(Color.LIGHT_GRAY);

            inputCreditorCodebitor2.setEnabled(false);
            inputCreditorCodebitor2.setBackground(Color.LIGHT_GRAY);

            inputSumaInitialaCodebitor2.setEnabled(false);
            inputSumaInitialaCodebitor2.setBackground(Color.LIGHT_GRAY);

            inputRataLunaraCodebitor2.setEnabled(false);
            inputRataLunaraCodebitor2.setBackground(Color.LIGHT_GRAY);

            inputSoldCreditCodebitor2.setEnabled(false);
            inputSoldCreditCodebitor2.setBackground(Color.LIGHT_GRAY);

            inputDataContractareCodebitor2.setEnabled(false);
            inputDataContractareCodebitor2.setBackground(Color.LIGHT_GRAY);

            inputScadentaCodebitor2.setEnabled(false);
            inputScadentaCodebitor2.setBackground(Color.LIGHT_GRAY);

            refinanteazaCodebitor2.setEnabled(false);
            intarzieriCodebitor2.setEnabled(false);
            inchideCodebitor2.setEnabled(false);
            
            // row22

            inputTipCreditCodebitor3.setEnabled(false);
            inputTipCreditCodebitor3.setBackground(Color.LIGHT_GRAY);

            inputCreditorCodebitor3.setEnabled(false);
            inputCreditorCodebitor3.setBackground(Color.LIGHT_GRAY);

            inputSumaInitialaCodebitor3.setEnabled(false);
            inputSumaInitialaCodebitor3.setBackground(Color.LIGHT_GRAY);

            inputRataLunaraCodebitor3.setEnabled(false);
            inputRataLunaraCodebitor3.setBackground(Color.LIGHT_GRAY);

            inputSoldCreditCodebitor3.setEnabled(false);
            inputSoldCreditCodebitor3.setBackground(Color.LIGHT_GRAY);

            inputDataContractareCodebitor3.setEnabled(false);
            inputDataContractareCodebitor3.setBackground(Color.LIGHT_GRAY);

            inputScadentaCodebitor3.setEnabled(false);
            inputScadentaCodebitor3.setBackground(Color.LIGHT_GRAY);

            refinanteazaCodebitor3.setEnabled(false);
            intarzieriCodebitor3.setEnabled(false);
            inchideCodebitor3.setEnabled(false);
            	
            // row23
            inputTipCreditCodebitor4.setEnabled(false);
            inputTipCreditCodebitor4.setBackground(Color.LIGHT_GRAY);

            inputCreditorCodebitor4.setEnabled(false);
            inputCreditorCodebitor4.setBackground(Color.LIGHT_GRAY);

            inputSumaInitialaCodebitor4.setEnabled(false);
            inputSumaInitialaCodebitor4.setBackground(Color.LIGHT_GRAY);

            inputRataLunaraCodebitor4.setEnabled(false);
            inputRataLunaraCodebitor4.setBackground(Color.LIGHT_GRAY);

            inputSoldCreditCodebitor4.setEnabled(false);
            inputSoldCreditCodebitor4.setBackground(Color.LIGHT_GRAY);

            inputDataContractareCodebitor4.setEnabled(false);
            inputDataContractareCodebitor4.setBackground(Color.LIGHT_GRAY);

            inputScadentaCodebitor4.setEnabled(false);
            inputScadentaCodebitor4.setBackground(Color.LIGHT_GRAY);

            refinanteazaCodebitor4.setEnabled(false);
            intarzieriCodebitor4.setEnabled(false);
			inchideCodebitor4.setEnabled(false);
		}

		
		inputNumarImobileCodebitor.setText(codebitor.getNrImobile());
		inputPADCodebitor.setText(codebitor.getPAD ());
		inputAsigurareCodebitor.setText(codebitor.getAsigurare());
		inputImpozitCodebitor.setText(codebitor.getImpozit());
		inputNumarMasiniCodebitor.setText(codebitor.getNrMasini());
		inputRCACodebitor.setText(codebitor.getRCA());
		inputCascoCodebitor.setText(codebitor.getCasco());
		inputImpozitMasinaCodebitor.setText(codebitor.getImpozitMasina());
		inputNumarCopiiCodebitor.setText(codebitor.getNumarCopii());
		inputNumarPersoaneIntretinereCodebitor.setText(codebitor.getNumarPersoaneIntretinere());
		
		inputTipCreditCodebitor1.setText(codebitor.getTipCredit1());
		inputCreditorCodebitor1.setText(codebitor.getCreditor1());
		inputSumaInitialaCodebitor1.setText(codebitor.getSumaInitiala1());
		inputRataLunaraCodebitor1.setText(codebitor.getRataLunara1());
		inputSoldCreditCodebitor1.setText(codebitor.getSoldCredit1 ());
		inputDataContractareCodebitor1.setText(codebitor.getDataContractare1());
		inputScadentaCodebitor1.setText(codebitor.getDataScadenta1());
		
		if(codebitor.getRefinantare1().matches("DA"))
			refinanteazaCodebitor1.setSelected(true);
		else
			refinanteazaCodebitor1.setSelected(false);
		
		
		if(codebitor.getIntarziere1().matches("DA"))
			intarzieriCodebitor1.setSelected(true);
		else
			intarzieriCodebitor1.setSelected(false);
		
		if(codebitor.getInchidere1().matches("DA"))
			inchideCodebitor1.setSelected(true);
		else
			inchideCodebitor1.setSelected(false);

		inputTipCreditCodebitor2.setText(codebitor.getTipCredit2());
		inputCreditorCodebitor2.setText(codebitor.getCreditor2());
		inputSumaInitialaCodebitor2.setText(codebitor.getSumaInitiala2());
		inputRataLunaraCodebitor2.setText(codebitor.getRataLunara2());
		inputSoldCreditCodebitor2.setText(codebitor.getSoldCredit2 ());
		inputDataContractareCodebitor2.setText(codebitor.getDataContractare2());
		inputScadentaCodebitor2.setText(codebitor.getDataScadenta2());
		
		if(codebitor.getRefinantare2().matches("DA"))
			refinanteazaCodebitor2.setSelected(true);
		else
			refinanteazaCodebitor2.setSelected(false);
		
		
		if(codebitor.getIntarziere2().matches("DA"))
			intarzieriCodebitor2.setSelected(true);
		else
			intarzieriCodebitor2.setSelected(false);
		
		if(codebitor.getInchidere2().matches("DA"))
			inchideCodebitor2.setSelected(true);
		else
			inchideCodebitor2.setSelected(false);
		
		inputTipCreditCodebitor3.setText(codebitor.getTipCredit3());
		inputCreditorCodebitor3.setText(codebitor.getCreditor3());
		inputSumaInitialaCodebitor3.setText(codebitor.getSumaInitiala3());
		inputRataLunaraCodebitor3.setText(codebitor.getRataLunara3());
		inputSoldCreditCodebitor3.setText(codebitor.getSoldCredit3 ());
		inputDataContractareCodebitor3.setText(codebitor.getDataContractare3());
		inputScadentaCodebitor3.setText(codebitor.getDataScadenta3());
		
		if(codebitor.getRefinantare3().matches("DA"))
			refinanteazaCodebitor3.setSelected(true);
		else
			refinanteazaCodebitor3.setSelected(false);
		
		
		if(codebitor.getIntarziere3().matches("DA"))
			intarzieriCodebitor3.setSelected(true);
		else
			intarzieriCodebitor3.setSelected(false);
		
		if(codebitor.getInchidere3().matches("DA"))
			inchideCodebitor3.setSelected(true);
		else
			inchideCodebitor3.setSelected(false);
		
		inputTipCreditCodebitor4.setText(codebitor.getTipCredit4());
		inputCreditorCodebitor4.setText(codebitor.getCreditor4());
		inputSumaInitialaCodebitor4.setText(codebitor.getSumaInitiala4());
		inputRataLunaraCodebitor4.setText(codebitor.getRataLunara4());
		inputSoldCreditCodebitor4.setText(codebitor.getSoldCredit4 ());
		inputDataContractareCodebitor4.setText(codebitor.getDataContractare4());
		inputScadentaCodebitor4.setText(codebitor.getDataScadenta4());
		
		if(codebitor.getRefinantare4().matches("DA"))
			refinanteazaCodebitor4.setSelected(true);
		else
			refinanteazaCodebitor4.setSelected(false);
		
		
		if(codebitor.getIntarziere4().matches("DA"))
			intarzieriCodebitor4.setSelected(true);
		else
			intarzieriCodebitor4.setSelected(false);
		
		if(codebitor.getInchidere4().matches("DA"))
			inchideCodebitor4.setSelected(true);
		else
			inchideCodebitor4.setSelected(false);
		
		for(int i = 0; i < abonamentType.length; i ++)
			if(abonamentType[i].matches(codebitor.getAbonament()))
				inputAbonamentCodebitor.setSelectedIndex(i);
		
		inputBroker.setText(codebitor.getBroker());
		inputUnit.setText(codebitor.getUnit());
		
	}
		
	
	public static void fillTemplate(String templatePath, String outputPath, String documentName, String[] templateTokens, 
			String[] informationTokens)
	{
		POIFSFileSystem fs = null;
		try
		{
			fs = new POIFSFileSystem(new FileInputStream(Paths.get(templatePath).toString()));
			HWPFDocument doc = new HWPFDocument(fs);

			for (int token = 0; token < templateTokens.length; token ++)
			{
				doc = replaceText(doc, templateTokens[token], informationTokens[token]);
			}
			
			try
			{
				new File(outputPath).mkdirs();
			}
			
			catch(SecurityException securityException)
			{
				infoLabel.setText("Nu s-a putut creea folderul clientului, cel mai probabil nu aveti permisiunea de a salva in aceasta locatie");
			}
			
			System.out.println(outputPath);
			String outputName = String.format("%s/%s.doc", outputPath, documentName);

			saveWord(outputName, doc);
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println(fileNotFoundException.getLocalizedMessage());
		}
		catch(IOException ioException)
		{
			System.err.println(ioException.getLocalizedMessage());
		}

	}

	public static void fillCommonTemplate(String templatePath, String outputPath, String documentName, String[] templateTitularTokens, 
			String[] informationTitularTokens, String[] templateCodebitorTokens, String[] informationCodebitorTokens )
	{
		POIFSFileSystem fs = null;
		try
		{
			fs = new POIFSFileSystem(new FileInputStream(Paths.get(templatePath).toString()));
			HWPFDocument doc = new HWPFDocument(fs);

			for (int token = 0; token < templateTitularTokens.length; token ++)
			{
				doc = replaceText(doc, templateTitularTokens[token], informationTitularTokens[token]);
			}
			
			for (int token = 0; token < templateCodebitorTokens.length; token ++)
			{
				doc = replaceText(doc, templateCodebitorTokens[token], informationCodebitorTokens[token]);
			}
			
			new File(outputPath).mkdirs();
			
			System.out.println(outputPath);
			String outputName = String.format("%s/%s.doc", outputPath, documentName);

			saveWord(outputName, doc);
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println(fileNotFoundException.getLocalizedMessage());
		}
		catch(IOException ioException)
		{
			System.err.println(ioException.getLocalizedMessage());
		}

	}
	
	private static HWPFDocument replaceText(HWPFDocument doc, String token, String informationToken)
	{
		Range range = doc.getRange();
		for (int i = 0; i < range.numSections(); i++)
		{
			Section section = range.getSection(i);
			for (int j = 0; j < section.numParagraphs(); j++)
			{
				Paragraph paragraph = section.getParagraph(j);
				for (int a = 0; a < paragraph.numCharacterRuns(); a++)
				{
					CharacterRun run = paragraph.getCharacterRun(a);
					String text = run.text();
					if(text.contains(token))
					{
						run.replaceText(token, informationToken);
						//System.out.println("token: " + token + " informationToken: " + informationToken);
					}

				}

			}
		}
		return doc;
	}

	private static void saveWord(String filePath, HWPFDocument doc) throws FileNotFoundException, IOException
	{
		FileOutputStream out = null;
		try
		{
			out = new FileOutputStream(filePath, false);
			doc.write(out);
			out.flush();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}
	
	private static void fillExcelTemplate(String templatePath, String outputPath, String documentName, String [] templateTokens,
			String[] informationTokens)
	{
		
		try
		{
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(Paths.get(templatePath).toString()));
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			new File(outputPath).mkdirs();
			
			for (int row = 0; row < 92; row++)
			{
				HSSFRow excelRow = sheet.getRow(row);
				for (int column = 1; column < 58; column ++)
				{
					HSSFCell excelCell = excelRow.getCell(column);
					try
					{
						String temp = excelCell.getStringCellValue();
						for (int i = 0; i < templateTokens.length; i++)
							if(temp.matches(templateTokens[i]))
								excelCell.setCellValue(informationTokens[i]);
								
					}
					
					catch(NullPointerException nullPointerException)
					{
					
					}
					
					catch(IllegalStateException illegalStateException)
					{
					
					}
				}
			}
			
			FileOutputStream out = null;
			try
			{
				String outputName = String.format("%s/%s.xls", outputPath, documentName);
				out = new FileOutputStream(outputName, false);
				workbook.write(out);
				out.flush();
				workbook.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			finally
			{
				out.close();
			}
					
		}
		
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println(fileNotFoundException.getLocalizedMessage());
		}
		catch(IOException ioException)
		{
			System.err.println(ioException.getLocalizedMessage());
		}
	}

	
}
