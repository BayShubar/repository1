package inexactUnitCalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * <p>
 * Title: CalculatorValue Class - A component of the Inexact Calculator Program
 * </p>
 *
 * <p>
 * Description: An entity object that provides inexact values to the calculator
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2011
 * </p>
 *
 * @author Duisebay Yerkebulan 1603-csse(21580)
 * @version 1.00
 */
public class CalculatorValue {
	
	private static final char POWER1 = '\u00b9';	// Superscript 1
	private static final char POWER2 = '\u00b2';	// Superscript 2
	private static final char POWER3 = '\u00b3';	// Superscript 3
	private static final char POWER4 = '\u2074';	// Superscript 4
	private static final char POWER5 = '\u2075';	// Superscript 5
	private static final char POWER6 = '\u2076';	// Superscript 6
	private static final char SSMINUS = '\u207B';	// Superscript minus
	private static final char DOTOP = '\u00B7';		// Dot Operator

	private static final String[] resultUnitNames = 
	    //0	
		{" ", 
		
	    //1       2     3         4            5            6             7            8 	       9       
		"mm",  "cm",  "m",  "mm"+POWER2,  "cm"+POWER2,  "m"+POWER2,  "mm"+POWER3, "cm"+POWER3, "m"+POWER3, 
		
			//10  11    12   13     14    15   16   17     18  
			"g", "kg", "s", "min", "hr", "A", "K", "mol", "cd",
			
		//   19           20              21               22               23                24
		"mm"+POWER4, "mm"+DOTOP+"g", "mm"+DOTOP+"kg", "mm"+DOTOP+"s", "mm"+DOTOP+"min", "mm"+DOTOP+"hr", 
			
			//   25              26              27                28 
			"mm"+DOTOP+"A", "mm"+DOTOP+"K", "mm"+DOTOP+"mol", "mm"+DOTOP+"cd", 
				
		//   29           30              31               32              33                34
		"cm"+POWER4, "cm"+DOTOP+"g", "cm"+DOTOP+"kg", "cm"+DOTOP+"s", "cm"+DOTOP+"min", "cm"+DOTOP+"hr", 
				
			//   35              36              37                38 
			"cm"+DOTOP+"A", "cm"+DOTOP+"K", "cm"+DOTOP+"mol", "cm"+DOTOP+"cd", 
					
		//  39          40             41              42             43               44
		"m"+POWER4, "m"+DOTOP+"g", "m"+DOTOP+"kg", "m"+DOTOP+"s", "m"+DOTOP+"min", "m"+DOTOP+"hr", 
		
		    //  45             46             47               48
			"m"+DOTOP+"A", "m"+DOTOP+"K", "m"+DOTOP+"mol", "m"+DOTOP+"cd", 
			
		//   49              50                     51                      52             
		"mm"+POWER5, "mm"+POWER2+DOTOP+"g", "mm"+POWER2+DOTOP+"kg", "mm"+POWER2+DOTOP+"s", 
		
			//          53                       54                      55                     56
			"mm"+POWER2+DOTOP+"min", "mm"+POWER2+DOTOP+"hr", "mm"+POWER2+DOTOP+"A", "mm"+POWER2+DOTOP+"K",
			
			//          57                       58
			"mm"+POWER2+DOTOP+"mol", "mm"+POWER2+DOTOP+"cd", 
				
		//   59                  60                     61                      62 
		"cm"+POWER5, "cm"+POWER2+DOTOP+"g", "cm"+POWER2+DOTOP+"kg", "cm"+POWER2+DOTOP+"s", 

			//          63                       64                      65                     66 
			"cm"+POWER2+DOTOP+"min", "cm"+POWER2+DOTOP+"hr", "cm"+POWER2+DOTOP+"A", "cm"+POWER2+DOTOP+"K", 
				
			//          67                       68 
			"cm"+POWER2+DOTOP+"mol", "cm"+POWER2+DOTOP+"cd", 
					
		//  69                 70                    71                     72                    73
		"m"+POWER5, "m"+POWER2+DOTOP+"g", "m"+POWER2+DOTOP+"kg", "m"+POWER2+DOTOP+"s", "m"+POWER2+DOTOP+"min", 
		
			//         74                     75                    76                    77		
			"m"+POWER2+DOTOP+"hr", "m"+POWER2+DOTOP+"A", "m"+POWER2+DOTOP+"K", "m"+POWER2+DOTOP+"mol", 
		
			//         78    
			"m"+POWER2+DOTOP+"cd", 		
			
		//   79                  80                     81                      82             
		"mm"+POWER6, "mm"+POWER3+DOTOP+"g", "mm"+POWER3+DOTOP+"kg", "mm"+POWER3+DOTOP+"s", 
		
			//          83                       84                      85                     86
			"mm"+POWER3+DOTOP+"min", "mm"+POWER3+DOTOP+"hr", "mm"+POWER3+DOTOP+"A", "mm"+POWER3+DOTOP+"K",
			
			//          87                       88
			"mm"+POWER3+DOTOP+"mol", "mm"+POWER3+DOTOP+"cd", 
				
		//   89                  90                      91                     92 
		"cm"+POWER6, "cm"+POWER3+DOTOP+"g", "cm"+POWER3+DOTOP+"kg", "cm"+POWER3+DOTOP+"s", 

			//          93                       94                      95                     96 
			"cm"+POWER3+DOTOP+"min", "cm"+POWER3+DOTOP+"hr", "cm"+POWER3+DOTOP+"A", "cm"+POWER3+DOTOP+"K", 
				
			//          97                       98 
			"cm"+POWER3+DOTOP+"mol", "cm"+POWER3+DOTOP+"cd", 
					
		//  99                 100                   101                    102            103
		"m"+POWER6, "m"+POWER3+DOTOP+"g", "m"+POWER3+DOTOP+"kg", "m"+POWER3+DOTOP+"s", "m"+POWER3+DOTOP+"min", 
		
			//         104                    105                   106                   107		
			"m"+POWER3+DOTOP+"hr", "m"+POWER3+DOTOP+"A", "m"+POWER3+DOTOP+"K", "m"+POWER3+DOTOP+"mol", 
		
			//         108   
			"m"+POWER3+DOTOP+"cd", 
						
		//  109             110             111            112                    113
		"g"+DOTOP+"mm", "g"+DOTOP+"cm", "g"+DOTOP+"m", "g"+DOTOP+"mm"+POWER2, "g"+DOTOP+"cm"+POWER2, 
		
		    //  114                   115                          116                    117             118
			"g"+DOTOP+"m"+POWER2, "g"+DOTOP+"mm"+POWER3, "g"+DOTOP+"cm"+POWER3, "g"+DOTOP+"m"+POWER3, "g"+POWER2, 
			
		    //  119            120              121             122            123		      124	
			"g"+DOTOP+"s", "g"+DOTOP+"min", "g"+DOTOP+"hr", "g"+DOTOP+"A", "g"+DOTOP+"K", "g"+DOTOP+"mol", 
		
		    //  125
			"g"+DOTOP+"cd", 
			
		//   126              127              128             129                     130
		"kg"+DOTOP+"mm", "kg"+DOTOP+"cm", "kg"+DOTOP+"m", "kg"+DOTOP+"mm"+POWER2, "kg"+DOTOP+"cm"+POWER2, 
		
	    	//         131                    132                     133                     134              135
			"kg"+DOTOP+"m"+POWER2, "kg"+DOTOP+"mm"+POWER3, "kg"+DOTOP+"cm"+POWER3, "kg"+DOTOP+"m"+POWER3, "kg"+POWER2, 
			
	    	//   136             137               138              139             140
			"kg"+DOTOP+"s", "kg"+DOTOP+"min", "kg"+DOTOP+"hr", "kg"+DOTOP+"A", "kg"+DOTOP+"K", 
			
			//	 141               142
			"kg"+DOTOP+"mol", "kg"+DOTOP+"cd", 
			
		//      143         144             145                  146                    147
		"s"+DOTOP+"mm", "s"+DOTOP+"cm", "s"+DOTOP+"m", "s"+DOTOP+"mm"+POWER2, "s"+DOTOP+"cm"+POWER2, 
		
			//        148                   149                    150                    151
			"s"+DOTOP+"m"+POWER2, "s"+DOTOP+"mm"+POWER3, "s"+DOTOP+"cm"+POWER3, "s"+DOTOP+"m"+POWER3, 

			//  152            153             154         155            156            157			
			"s"+DOTOP+"g", "s"+DOTOP+"kg", "s"+POWER2, "s"+DOTOP+"A", "s"+DOTOP+"K", "s"+DOTOP+"mol",

			//  158
			"s"+DOTOP+"cd", 
			
		//    159               160               161                    162                      163
		"min"+DOTOP+"mm", "min"+DOTOP+"cm", "min"+DOTOP+"m", "min"+DOTOP+"mm"+POWER2, "min"+DOTOP+"cm"+POWER2, 
		
			//    164                           165                      166                      167
			"min"+DOTOP+"m"+POWER2, "min"+DOTOP+"mm"+POWER3, "min"+DOTOP+"cm"+POWER3, "min"+DOTOP+"m"+POWER3, 
			
			//    168              169               170           171              172              173
			"min"+DOTOP+"g", "min"+DOTOP+"kg", "min"+POWER2, "min"+DOTOP+"A", "min"+DOTOP+"K", "min"+DOTOP+"mol",
			
			//    174
			"min"+DOTOP+"cd", 
			
		//   175              176              177             178                           179
		"hr"+DOTOP+"mm", "hr"+DOTOP+"cm", "hr"+DOTOP+"m", "hr"+DOTOP+"hr"+POWER2, "hr"+DOTOP+"cm"+POWER2, 
		
			//         180                    181                     182                     183
			"hr"+DOTOP+"m"+POWER2, "hr"+DOTOP+"mm"+POWER3, "hr"+DOTOP+"cm"+POWER3, "hr"+DOTOP+"m"+POWER3, 
			
			//   184             185              186          187             188             189
			"hr"+DOTOP+"g", "hr"+DOTOP+"kg", "hr"+POWER2, "hr"+DOTOP+"A", "hr"+DOTOP+"K", "hr"+DOTOP+"mol",
			
			//   190
			"hr"+DOTOP+"cd", 
			
		//  191             192             193                  194                    195
		"A"+DOTOP+"mm", "A"+DOTOP+"cm", "A"+DOTOP+"m", "A"+DOTOP+"mm"+POWER2, "A"+DOTOP+"cm"+POWER2, 
		
			//        196                   197                    198                    199
			"A"+DOTOP+"m"+POWER3, "A"+DOTOP+"mm"+POWER3, "A"+DOTOP+"cm"+POWER3, "A"+DOTOP+"m"+POWER2, 
			
			//  200            201             202            203              204             205
			"A"+DOTOP+"g", "A"+DOTOP+"kg", "A"+DOTOP+"s", "A"+DOTOP+"min", "A"+DOTOP+"hr", "A"+POWER2, 
			
			//  206            207              208
			"A"+DOTOP+"K", "A"+DOTOP+"mol", "A"+DOTOP+"cd", 
			
		//      209             210             211                  212                    213
			"K"+DOTOP+"mm", "K"+DOTOP+"cm", "K"+DOTOP+"m", "K"+DOTOP+"mm"+POWER2, "K"+DOTOP+"cm"+POWER2,
			
			//        214                   215                    216                    217
			"K"+DOTOP+"m"+POWER2, "K"+DOTOP+"mm"+POWER3, "K"+DOTOP+"cm"+POWER3, "K"+DOTOP+"m"+POWER3, 
			
			//  218            219             220            221              222
			"K"+DOTOP+"g", "K"+DOTOP+"kg", "K"+DOTOP+"s", "K"+DOTOP+"min", "K"+DOTOP+"hr", 
			
			//  223            224         225              226
			"K"+DOTOP+"A", "K"+POWER2, "K"+DOTOP+"mol", "K"+DOTOP+"cd", 
			
		//    227               228               229                    230                      231
		"mol"+DOTOP+"mm", "mol"+DOTOP+"cm", "mol"+DOTOP+"m", "mol"+DOTOP+"mm"+POWER2, "mol"+DOTOP+"cm"+POWER2, 
		
			//    232                     233                      234                      235
			"mol"+DOTOP+"m"+POWER2, "mol"+DOTOP+"mm"+POWER3, "mol"+DOTOP+"cm"+POWER3, "mol"+DOTOP+"m"+POWER2,
			
			//    236              237               238              239                240
			"mol"+DOTOP+"g", "mol"+DOTOP+"kg", "mol"+DOTOP+"s", "mol"+DOTOP+"min", "mol"+DOTOP+"hr", 
			
			//    241              242              243           244
			"mol"+DOTOP+"A", "mol"+DOTOP+"K", "mol"+POWER2, "mol"+DOTOP+"cd",
			
		//   245              246              247                   248                     249
		"cd"+DOTOP+"mm", "cd"+DOTOP+"cm", "cd"+DOTOP+"m", "cd"+DOTOP+"mm"+POWER2, "cd"+DOTOP+"cm"+POWER2, 
		
			//         250                    251                     252                     253  
			"cd"+DOTOP+"m"+POWER2, "cd"+DOTOP+"mm"+POWER3, "cd"+DOTOP+"cm"+POWER3, "cd"+DOTOP+"m"+POWER3, 
			
			//   254             255              256             257               258
			"cd"+DOTOP+"g", "cd"+DOTOP+"kg", "cd"+DOTOP+"s", "cd"+DOTOP+"min", "cd"+DOTOP+"hr", 
			
			//   259             260             261               262
			"cd"+DOTOP+"A", "cd"+DOTOP+"K", "cd"+DOTOP+"mol", "cd"+POWER2,
		

			// UNITS REQUIRED FOR THE DIVISION OPERATOR

			//          263                  264       265     266      267     268       269      270     271     272       273
			"mm"+SSMINUS+POWER1, "mm"+SSMINUS+POWER2, "mm/g", "mm/kg", "mm/s", "mm/min", "mm/hr", "mm/A", "mm/K", "mm/mol", "mm/cd",
			
			//          274                  275       276     277      278     279       280      281     282     283       284
			"cm"+SSMINUS+POWER1, "cm"+SSMINUS+POWER2, "cm/g", "cm/kg", "cm/s", "cm/min", "cm/hr", "cm/A", "cm/K", "cm/mol", "cm/cd",
			
			//          285                 286      287    288     289    290      291     292    293     294      295
			"m"+SSMINUS+POWER1, "m"+SSMINUS+POWER2, "m/g", "m/kg", "m/s", "m/min", "m/hr", "m/A", "cm/K", "m/mol", "m/cd",

			//     296               297                298               299                 300                301               302               303                 304
			"mm"+POWER2+"/g", "mm"+POWER2+"/kg", "mm"+POWER2+"/s", "mm"+POWER2+"/min", "mm"+POWER2+"/hr", "mm"+POWER2+"/A", "mm"+POWER2+"/K", "mm"+POWER2+"/mol", "mm"+POWER2+"/cd",
			
			//     305               306                307               308                 309                310               311               312                 313
			"cm"+POWER2+"/g", "cm"+POWER2+"/kg", "cm"+POWER2+"/s", "cm"+POWER2+"/min", "cm"+POWER2+"/hr", "cm"+POWER2+"/A", "cm"+POWER2+"/K", "cm"+POWER2+"/mol", "cm"+POWER2+"/cd",
			
			//     314              315               316             317                318               319              320              321                322
			"m"+POWER2+"/g", "m"+POWER2+"/kg", "m"+POWER2+"/s", "m"+POWER2+"/min", "m"+POWER2+"/hr", "m"+POWER2+"/A", "m"+POWER2+"/K", "m"+POWER2+"/mol", "m"+POWER2+"/cd",

			//      323               324                325               326                 327                328               329               330                 331
			"mm"+POWER3+"/g", "mm"+POWER3+"/kg", "mm"+POWER3+"/s", "mm"+POWER3+"/min", "mm"+POWER3+"/hr", "mm"+POWER3+"/A", "mm"+POWER3+"/K", "mm"+POWER3+"/mol", "mm"+POWER3+"/cd",
			
			//      332               333                334               335                 336                337               338               339                 340
			"cm"+POWER3+"/g", "cm"+POWER3+"/kg", "cm"+POWER3+"/s", "cm"+POWER3+"/min", "cm"+POWER3+"/hr", "cm"+POWER3+"/A", "cm"+POWER3+"/K", "cm"+POWER3+"/mol", "cm"+POWER3+"/cd",
			
			//     341              342               343              344                345               346              347              348                349
			"m"+POWER3+"/g", "m"+POWER3+"/kg", "m"+POWER3+"/s", "m"+POWER3+"/min", "m"+POWER3+"/hr", "m"+POWER3+"/A", "m"+POWER3+"/K", "m"+POWER3+"/mol", "m"+POWER3+"/cd",

			//350    351     352         353            354           355            356            357           358       359    360      361     362    363    364      365
			"g/mm", "g/cm", "g/m", "g/mm"+POWER2, "g/cm"+POWER2, "g/m"+POWER2, "g/mm"+POWER3, "g/cm"+POWER3, "g/m"+POWER3, "g/s", "g/min", "g/hr", "g/A", "g/K", "g/mol", "g/cd", 
			
			//366     367      368           369             370            371             372             373            374       375     376       377      378     379     380       381
			"kg/mm", "kg/cm", "kg/m", "kg/mm"+POWER2, "kg/cm"+POWER2, "kg/m"+POWER2, "kg/mm"+POWER3, "kg/cm"+POWER3, "kg/m"+POWER3, "kg/s", "kg/min", "kg/hr", "kg/A", "kg/K", "kg/mol", "kg/cd", 

			//382    383     384         385            386           387            388            389           390       391    392     393    394    395      396
			"s/mm", "s/cm", "s/m", "s/mm"+POWER2, "s/cm"+POWER2, "s/m"+POWER2, "s/mm"+POWER3, "s/cm"+POWER3, "s/m"+POWER3, "s/g", "s/kg", "s/A", "s/K", "s/mol", "s/cd", 
			
			//397      398       399             400              401             402              403              404             405       406      407       408      409      410        411
			"min/mm", "min/cm", "min/m", "min/mm"+POWER2, "min/cm"+POWER2, "min/m"+POWER2, "min/mm"+POWER3, "min/cm"+POWER3, "min/m"+POWER3, "min/g", "min/kg", "min/A", "min/K", "min/mol", "min/cd",
			
			//412     413      414           415             416            417             418             419            420       421     422      423     424     425       426
			"hr/mm", "hr/cm", "hr/m", "hr/mm"+POWER2, "hr/cm"+POWER2, "hr/m"+POWER2, "hr/mm"+POWER3, "hr/cm"+POWER3, "hr/m"+POWER3, "hr/g", "hr/kg", "hr/A", "hr/K", "hr/mol", "hr/cd", 
			
			//427    428     429         430            431           432            433            434           435       436    437     438    439      440     441    442      443
			"A/mm", "A/cm", "A/m", "A/mm"+POWER2, "A/cm"+POWER2, "A/m"+POWER2, "A/mm"+POWER3, "A/cm"+POWER3, "A/m"+POWER3, "A/g", "A/kg", "A/s", "A/min", "A/hr", "A/K", "A/mol", "A/cd", 

			//444    445     446         447            448           449            450            451           452       453    454     455    456      457     458    459      460
			"K/mm", "K/cm", "K/m", "K/mm"+POWER2, "K/cm"+POWER2, "K/m"+POWER2, "K/mm"+POWER3, "K/cm"+POWER3, "K/m"+POWER3, "K/g", "K/kg", "K/s", "K/min", "K/hr", "K/A", "K/mol", "K/cd", 

			//461      462       463             464              465             466              467              468             469       470      471       472      473        474       475      476      477
			"mol/mm", "mol/cm", "mol/m", "mol/mm"+POWER2, "mol/cm"+POWER2, "mol/m"+POWER2, "mol/mm"+POWER3, "mol/cm"+POWER3, "mol/m"+POWER3, "mol/g", "mol/kg", "mol/s", "mol/min", "mol/hr", "mol/A", "mol/K", "mol/cd", 

			//478     479      480           481             482            483             484             485            486       487     488      489     490       491      492     493     494  
			"cd/mm", "cd/cm", "cd/m", "cd/mm"+POWER2, "cd/cm"+POWER2, "cd/m"+POWER2, "cd/mm"+POWER3, "cd/cm"+POWER3, "cd/m"+POWER3, "cd/g", "cd/kg", "cd/s", "cd/min", "cd/hr", "cd/A", "cd/K", "cd/mol", 

		};
	
	private static final int [][] addsub = 
		{
			{  0,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,   1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,   2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,   3,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,   4,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,   5,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,   6,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,   7,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   8,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   9,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  10,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  11,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  12,  -1,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  13,  -1,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  14,  -1,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  15,  -1,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  16,  -1,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  17,  -1},
			{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  18},
		};
	private static final int [][] mpy = 
		{
			{  0,   1,   2,   3,   4,   5,   6,   7,   8,   9,  10,  11,  12,  13,  14,  15,  16,  17,  18},
			{  1,   4,  -1,  -1,   7,  -1,  -1,  19,  -1,  -1,  20,  21,  22,  23,  24,  25,  26,  27,  28},
			{  2,  -1,   5,  -1,  -1,   8,  -1,  -1,  29,  -1,  30,  31,  32,  33,  34,  35,  36,  37,  38},
			{  3,  -1,  -1,   6,  -1,  -1,   9,  -1,  -1,  39,  40,  41,  42,  43,  44,  45,  46,  47,  48},
			{  4,   7,  -1,  -1,  19,  -1,  -1,  49,  -1,  -1,  50,  51,  52,  53,  54,  55,  56,  57,  58},
			{  5,  -1,   8,  -1,  -1,  29,  -1,  -1,  59,  -1,  60,  61,  62,  63,  64,  65,  66,  67,  68},
			{  6,  -1,  -1,   9,  -1,  -1,  39,  -1,  -1,  69,  70,  71,  72,  73,  74,  75,  76,  77,  78},
			{  7,  19,  -1,  -1,  49,  -1,  -1,  79,  -1,  -1,  80,  81,  82,  83,  84,  85,  86,  87,  88},
			{  8,  -1,  29,  -1,  -1,  59,  -1,  -1,  89,  -1,  90,  91,  92,  93,  94,  95,  96,  97,  98},
			{  9,  -1,  -1,  39,  -1,  -1,  69,  -1,  -1,  99, 100, 101, 102, 103, 104, 105, 106, 107, 108},
			{ 10, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118,  -1, 119, 120, 121, 122, 123, 124, 125},
			{ 11, 126, 127, 128, 129, 130, 131, 132, 133, 134,  -1, 135, 136, 137, 138, 139, 140, 141, 142},
			{ 12, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154,  -1,  -1, 155, 156, 157, 158},
			{ 13, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,  -1, 170,  -1, 171, 172, 173, 174},
			{ 14, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185,  -1,  -1, 186, 187, 188, 189, 190},
			{ 15, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208},
			{ 16, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226},
			{ 17, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244},
			{ 18, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 258, 260, 261, 262},
		};
	private static final int [][] div =
		{
			{  0,   1,   2,   3,   4,   5,   6,   7,   8,   9,  10,  11,  12,  13,  14,  15,  16,  17,  18},
			{  1,   0,  -1,  -1, 263,  -1,  -1, 264,  -1,  -1, 265, 266, 267, 268, 269, 270, 271, 272, 273},
			{  2,  -1,   0,  -1,  -1, 274,  -1,  -1, 275,  -1, 276, 277, 278, 279, 280, 281, 282, 283, 284},
			{  3,  -1,  -1,   0,  -1,  -1, 285,  -1,  -1, 287, 287, 288, 289, 290, 291, 292, 293, 294, 295},
			{  4,   1,  -1,  -1,   0,  -1,  -1, 263,  -1,  -1, 296, 297, 298, 299, 300, 301, 302, 303, 304},
			{  5,  -1,   2,  -1,  -1,   0,  -1,  -1, 274,  -1, 305, 306, 307, 308, 309, 310, 311, 312, 313},
			{  6,  -1,  -1,   3,  -1,  -1,   0,  -1,  -1, 285, 314, 315, 316, 317, 318, 319, 320, 321, 322},
			{  7,   4,  -1,  -1,   1,  -1,  -1,   0,  -1,  -1, 323, 324, 325, 326, 327, 328, 329, 330, 331},
			{  8,  -1,   5,  -1,  -1,   2,  -1,  -1,   0,  -1, 332, 333, 334, 335, 336, 337, 338, 339, 340},
			{  9,  -1,  -1,   6,  -1,  -1,   3,  -1,  -1,   0, 341, 342, 343, 344, 345, 346, 347, 348, 349},
			{ 10, 350, 351, 352, 353, 354, 355, 356, 357, 358,   0,  -1, 359, 360, 361, 362, 363, 364, 365},
			{ 11, 366, 367, 368, 369, 370, 371, 372, 373, 374,  -1,   0, 375, 376, 377, 378, 379, 380, 381},
			{ 12, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392,   0,  -1,  -1, 393, 394, 395, 396},
			{ 13, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407,  -1,   0,  -1, 408, 409, 410, 411},
			{ 14, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422,  -1,  -1,   0, 423, 424, 425, 426},
			{ 15, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440,   0, 441, 442, 443},
			{ 16, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458,   0, 459, 460},
			{ 17, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476,   0, 477},
			{ 18, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494,   0},
		};

	private UNumber value = new UNumber(0.0);			// The representation of the value
	private double errorTerm = 0.0;		// Specifies the error term
	private int units;					// The units for this value
	private NumberFormat scientific = new DecimalFormat("0.0E0");

	private static final char plusMinus = '\u00b1';

	/*****
	 * Fully parameterized constructor for the class
	 * 
	 * @param v		A double that specifies the value of the calculator value
	 * @param e		A double that specifies the error-term
	 * @param i		A String that specifies the units
	 */
	public CalculatorValue(UNumber v, double e, int i) {
		value = v;
		errorTerm = e;
		units = i;
	}
	
	public CalculatorValue(CalculatorValue u) {
		value = u.value;
		errorTerm = u.errorTerm;
		units = 0;
	}

	/*****
	 * Default constructor for the class
	 */
	public CalculatorValue() {
		value = new UNumber(0.0);
		errorTerm = 0.0;
		units = 0;
	}
	
	public UNumber getValue(){
		return value;
	}
	
	public double getErrorTerm(){
		return errorTerm;
	}
	
	public double getUnits(){
		return units;
	}
		
	
	public String toString() {
		if (units < 0)
			return "";
		else
			 return value + " " + plusMinus + " " + scientific.format(errorTerm) + " " + resultUnitNames[units];

	}
	
	static public CalculatorValue add(CalculatorValue a, CalculatorValue b) {
		UNumber temA =new UNumber(new UNumber(a.value));
		UNumber temB =new UNumber(new UNumber(b.value));
		temA.add(temB);
			return new CalculatorValue(temA , a.errorTerm + b.errorTerm, addsub[a.units][b.units]);		
	}
	
	static public CalculatorValue sub(CalculatorValue a, CalculatorValue b) {
		UNumber temA =new UNumber(new UNumber(a.value));
		UNumber temB =new UNumber(new UNumber(b.value));
		temA.sub(temB);
		return new CalculatorValue(temA, a.errorTerm + b.errorTerm, addsub[a.units][b.units]);
	}
	
	static public CalculatorValue mpy(CalculatorValue a, CalculatorValue b) {
		UNumber temA =new UNumber(new UNumber(a.value));
		UNumber temB =new UNumber(new UNumber(b.value));
		temA.mpy(temB);
		double e = Math.abs(temA.getDouble());
		return new CalculatorValue(temA, (a.errorTerm/e + b.errorTerm/e)*e, mpy[a.units][b.units]);
	}
	
	static public CalculatorValue div(CalculatorValue a, CalculatorValue b) {
		UNumber temA =new UNumber(new UNumber(a.value));
		UNumber temB =new UNumber(new UNumber(b.value));
		temA.div(temB);
		double e = Math.abs(temA.getDouble());
		return new CalculatorValue(temA, (a.errorTerm/e + b.errorTerm/e)*e, div[a.units][b.units]);
	}
}
