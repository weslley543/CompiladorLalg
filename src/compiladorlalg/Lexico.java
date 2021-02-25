/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlalg;

/**
 *
 * @author giuli
 */
public class Lexico {
    
  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\45\1\46\1\46\1\45\22\0\1\1\7\0\1\32"+
    "\1\33\1\40\1\37\1\30\1\41\1\34\1\44\1\3\11\2\1\27"+
    "\1\31\1\42\1\36\1\43\2\0\32\51\4\0\1\51\1\0\1\10"+
    "\1\22\1\26\1\23\1\14\1\15\1\7\1\35\1\20\2\51\1\16"+
    "\1\11\1\21\1\6\1\4\1\51\1\5\1\17\1\12\1\13\1\25"+
    "\1\24\3\51\1\47\1\0\1\50\7\0\1\46\u1fa2\0\1\46\1\46"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\16\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\2\1\1\3\3\4\1\21\6\4\1\22\4\4"+
    "\1\23\4\4\1\24\1\25\1\26\1\27\1\30\1\0"+
    "\1\3\3\4\1\31\3\4\1\32\1\4\1\33\1\34"+
    "\2\4\1\35\2\4\1\36\1\30\1\3\3\4\1\37"+
    "\1\40\1\22\5\4\1\3\3\4\1\41\1\4\1\42"+
    "\1\43\1\23\1\3\4\4\1\3\1\4\1\44\1\4"+
    "\1\45\1\3\2\4\1\3\1\4\1\46\1\3\1\4"+
    "\1\47\1\4\1\47\1\4\1\47\1\4\1\47\1\4"+
    "\1\47\1\4\1\47\1\4\1\47\1\4\1\47\1\4"+
    "\1\47\1\4\1\47\1\4\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50\1\47\1\50"+
    "\1\47\1\50\1\47\1\50\1\47\1\50";

  private static int [] zzUnpackAction() {
    int [] result = new int[299];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\52\0\52\0\124\0\176\0\250\0\322\0\374"+
    "\0\u0126\0\u0150\0\u017a\0\u01a4\0\u01ce\0\u01f8\0\u0222\0\u024c"+
    "\0\u0276\0\u02a0\0\u02ca\0\52\0\52\0\52\0\52\0\52"+
    "\0\52\0\52\0\52\0\52\0\u02f4\0\u031e\0\u0348\0\u0372"+
    "\0\u039c\0\u03c6\0\u03f0\0\u041a\0\u03c6\0\u0444\0\u046e\0\u0498"+
    "\0\u04c2\0\u04ec\0\u0516\0\u03c6\0\u0540\0\u056a\0\u0594\0\u05be"+
    "\0\u03c6\0\u05e8\0\u0612\0\u063c\0\u0666\0\52\0\52\0\52"+
    "\0\52\0\u0348\0\u0690\0\u06ba\0\u06e4\0\u070e\0\u0738\0\u06e4"+
    "\0\u0762\0\u078c\0\u07b6\0\u06e4\0\u07e0\0\u06e4\0\u06e4\0\u080a"+
    "\0\u0834\0\u06e4\0\u085e\0\u0888\0\u06e4\0\52\0\u08b2\0\u08dc"+
    "\0\u0906\0\u0930\0\u08dc\0\u08dc\0\u08dc\0\u095a\0\u0984\0\u09ae"+
    "\0\u09d8\0\u0a02\0\u0a2c\0\u0a56\0\u0a80\0\u0aaa\0\u0a56\0\u0ad4"+
    "\0\u0a56\0\u0a56\0\u0a56\0\u0afe\0\u0b28\0\u0b52\0\u0b7c\0\u0ba6"+
    "\0\u0bd0\0\u0bfa\0\u0bfa\0\u0c24\0\u0bfa\0\u0c4e\0\u0c78\0\u0ca2"+
    "\0\u0ccc\0\u0cf6\0\u0cf6\0\u0d20\0\u0d4a\0\u0d74\0\u0d9e\0\u0dc8"+
    "\0\u0df2\0\u0e1c\0\u0e46\0\u0e70\0\u0e9a\0\u0ec4\0\u0eee\0\u0f18"+
    "\0\u0f42\0\u0f6c\0\u0f96\0\u0fc0\0\u0fea\0\u1014\0\u103e\0\u1068"+
    "\0\u1092\0\u10bc\0\u10e6\0\u1110\0\u113a\0\u1164\0\u118e\0\u11b8"+
    "\0\u11e2\0\u120c\0\u1236\0\u1260\0\u128a\0\u12b4\0\u12de\0\u1308"+
    "\0\u1332\0\u135c\0\u1386\0\u13b0\0\u13da\0\u1404\0\u142e\0\u1458"+
    "\0\u1482\0\u14ac\0\u14d6\0\u1500\0\u152a\0\u1554\0\u157e\0\u15a8"+
    "\0\u15d2\0\u15fc\0\u1626\0\u1650\0\u167a\0\u16a4\0\u16ce\0\u16f8"+
    "\0\u1722\0\u174c\0\u1776\0\u17a0\0\u17ca\0\u17f4\0\u181e\0\u1848"+
    "\0\u1872\0\u189c\0\u18c6\0\u18f0\0\u191a\0\u1944\0\u196e\0\u1998"+
    "\0\u19c2\0\u19ec\0\u1a16\0\u1a40\0\u1a6a\0\u1a94\0\u1abe\0\u1ae8"+
    "\0\u1b12\0\u1b3c\0\u1b66\0\u1b90\0\u1bba\0\u1be4\0\u1c0e\0\u1c38"+
    "\0\u1c62\0\u1c8c\0\u1cb6\0\u1ce0\0\u1d0a\0\u1d34\0\u1d5e\0\u1d88"+
    "\0\u1db2\0\u1ddc\0\u1e06\0\u1e30\0\u1e5a\0\u1e84\0\u1eae\0\u1ed8"+
    "\0\u1f02\0\u1f2c\0\u1f56\0\u1f80\0\u1faa\0\u1fd4\0\u1ffe\0\u2028"+
    "\0\u2052\0\u207c\0\u20a6\0\u20d0\0\u20fa\0\u2124\0\u214e\0\u2178"+
    "\0\u21a2\0\u21cc\0\u21f6\0\u2220\0\u224a\0\u2274\0\u229e\0\u22c8"+
    "\0\u22f2\0\u231c\0\u2346\0\u2370\0\u239a\0\u23c4\0\u23ee\0\u2418"+
    "\0\u2442\0\u246c\0\u2496\0\u24c0\0\u24ea\0\u2514\0\u253e\0\u2568"+
    "\0\u2592\0\u25bc\0\u25e6\0\u2610\0\u263a\0\u2664\0\u268e\0\u26b8"+
    "\0\u26e2\0\u270c\0\u2736\0\u2760\0\u278a\0\u27b4\0\u27de\0\u2808"+
    "\0\u2832\0\u285c\0\u2886\0\u28b0\0\u28da\0\u2904\0\u292e\0\u2958"+
    "\0\u2982\0\u29ac\0\u29d6\0\u2a00\0\u2a2a\0\u2a54\0\u2a7e\0\u2aa8"+
    "\0\u2ad2\0\52\0\52";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[299];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\11\1\10\1\12\1\10\1\13\1\14\2\10\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\10\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\10\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\3\1\0\1\40\1\2"+
    "\1\10\54\0\2\41\50\0\3\42\1\43\21\42\6\0"+
    "\1\42\13\0\1\42\2\0\12\42\1\44\12\42\6\0"+
    "\1\42\13\0\1\42\2\0\3\42\1\45\21\42\6\0"+
    "\1\42\13\0\1\42\2\0\25\42\6\0\1\42\13\0"+
    "\1\42\2\0\17\42\1\46\5\42\6\0\1\42\13\0"+
    "\1\42\2\0\3\42\1\47\21\42\6\0\1\50\13\0"+
    "\1\42\2\0\14\42\1\51\2\42\1\52\5\42\6\0"+
    "\1\42\13\0\1\42\2\0\6\42\1\53\16\42\6\0"+
    "\1\42\13\0\1\42\2\0\13\42\1\54\3\42\1\55"+
    "\5\42\6\0\1\42\13\0\1\42\2\0\4\42\1\56"+
    "\20\42\6\0\1\42\13\0\1\42\2\0\4\42\1\57"+
    "\5\42\1\60\12\42\6\0\1\42\13\0\1\42\2\0"+
    "\4\42\1\61\11\42\1\62\6\42\6\0\1\42\13\0"+
    "\1\42\2\0\3\42\1\63\21\42\6\0\1\64\13\0"+
    "\1\42\2\0\6\42\1\65\16\42\6\0\1\42\13\0"+
    "\1\42\36\0\1\66\51\0\1\67\4\0\1\70\44\0"+
    "\1\71\13\0\45\72\2\0\3\72\50\73\1\0\1\73"+
    "\2\0\2\74\50\0\25\75\6\0\1\75\13\0\1\75"+
    "\2\0\4\75\1\76\20\75\6\0\1\75\13\0\1\75"+
    "\2\0\6\75\1\77\16\75\6\0\1\75\13\0\1\75"+
    "\2\0\21\75\1\100\3\75\6\0\1\75\13\0\1\75"+
    "\2\0\11\75\1\101\13\75\6\0\1\75\13\0\1\75"+
    "\2\0\12\75\1\102\12\75\6\0\1\75\13\0\1\75"+
    "\2\0\15\75\1\103\7\75\6\0\1\75\13\0\1\75"+
    "\2\0\21\75\1\104\3\75\6\0\1\75\13\0\1\75"+
    "\2\0\14\75\1\105\10\75\6\0\1\75\13\0\1\75"+
    "\2\0\10\75\1\106\14\75\6\0\1\75\13\0\1\75"+
    "\2\0\10\75\1\107\14\75\6\0\1\75\13\0\1\75"+
    "\2\0\4\75\1\110\20\75\6\0\1\75\13\0\1\75"+
    "\2\0\5\75\1\111\17\75\6\0\1\75\13\0\1\75"+
    "\2\0\23\75\1\112\1\75\6\0\1\75\13\0\1\75"+
    "\2\0\16\75\1\113\6\75\6\0\1\75\13\0\1\75"+
    "\2\0\16\75\1\114\6\75\6\0\1\75\13\0\1\75"+
    "\2\0\3\75\1\115\21\75\6\0\1\75\13\0\1\75"+
    "\50\73\1\116\1\73\2\0\2\117\50\0\25\120\6\0"+
    "\1\120\13\0\1\120\2\0\5\120\1\121\16\120\1\122"+
    "\6\0\1\120\13\0\1\120\2\0\21\120\1\123\3\120"+
    "\6\0\1\120\13\0\1\120\2\0\12\120\1\124\12\120"+
    "\6\0\1\120\13\0\1\120\2\0\17\120\1\125\5\120"+
    "\6\0\1\120\13\0\1\120\2\0\12\120\1\125\12\120"+
    "\6\0\1\120\13\0\1\120\2\0\15\120\1\126\7\120"+
    "\6\0\1\120\13\0\1\120\2\0\14\120\1\127\10\120"+
    "\6\0\1\120\13\0\1\120\2\0\16\120\1\130\6\120"+
    "\6\0\1\120\13\0\1\120\2\0\10\120\1\131\14\120"+
    "\6\0\1\120\13\0\1\120\2\0\14\120\1\132\10\120"+
    "\6\0\1\120\13\0\1\120\2\0\2\133\50\0\25\134"+
    "\6\0\1\134\13\0\1\134\2\0\3\134\1\135\21\134"+
    "\6\0\1\134\13\0\1\134\2\0\12\134\1\136\12\134"+
    "\6\0\1\134\13\0\1\134\2\0\12\134\1\137\12\134"+
    "\6\0\1\134\13\0\1\134\2\0\12\134\1\140\12\134"+
    "\6\0\1\134\13\0\1\134\2\0\17\134\1\141\5\134"+
    "\6\0\1\134\13\0\1\134\2\0\12\134\1\142\12\134"+
    "\6\0\1\134\13\0\1\134\2\0\12\134\1\143\12\134"+
    "\6\0\1\134\13\0\1\134\2\0\2\144\50\0\25\145"+
    "\6\0\1\145\13\0\1\145\2\0\6\145\1\146\16\145"+
    "\6\0\1\145\13\0\1\145\2\0\21\145\1\147\3\145"+
    "\6\0\1\145\13\0\1\145\2\0\6\145\1\150\16\145"+
    "\6\0\1\145\13\0\1\145\2\0\2\151\50\0\25\152"+
    "\6\0\1\152\13\0\1\152\2\0\7\152\1\153\15\152"+
    "\6\0\1\152\13\0\1\152\2\0\11\152\1\154\13\152"+
    "\6\0\1\152\13\0\1\152\2\0\17\152\1\155\5\152"+
    "\6\0\1\152\13\0\1\152\2\0\2\156\50\0\25\157"+
    "\6\0\1\157\13\0\1\157\2\0\3\157\1\160\21\157"+
    "\6\0\1\157\13\0\1\157\2\0\2\161\50\0\25\162"+
    "\6\0\1\162\13\0\1\162\2\0\12\162\1\163\12\162"+
    "\6\0\1\162\13\0\1\162\2\0\2\164\50\0\25\165"+
    "\6\0\1\165\13\0\1\165\2\0\2\166\50\0\25\167"+
    "\6\0\1\167\13\0\1\167\2\0\2\170\50\0\25\171"+
    "\6\0\1\171\13\0\1\171\2\0\2\172\50\0\25\173"+
    "\6\0\1\173\13\0\1\173\2\0\2\174\50\0\25\175"+
    "\6\0\1\175\13\0\1\175\2\0\2\176\50\0\25\177"+
    "\6\0\1\177\13\0\1\177\2\0\2\200\50\0\25\201"+
    "\6\0\1\201\13\0\1\201\2\0\2\202\50\0\25\203"+
    "\6\0\1\203\13\0\1\203\2\0\2\204\50\0\25\205"+
    "\6\0\1\205\13\0\1\205\2\0\2\206\50\0\25\207"+
    "\6\0\1\207\13\0\1\207\2\0\2\210\50\0\25\211"+
    "\6\0\1\211\13\0\1\211\2\0\2\212\50\0\25\213"+
    "\6\0\1\213\13\0\1\213\2\0\2\214\50\0\25\215"+
    "\6\0\1\215\13\0\1\215\2\0\2\216\50\0\25\217"+
    "\6\0\1\217\13\0\1\217\2\0\2\220\50\0\25\221"+
    "\6\0\1\221\13\0\1\221\2\0\2\222\50\0\25\223"+
    "\6\0\1\223\13\0\1\223\2\0\2\224\50\0\25\225"+
    "\6\0\1\225\13\0\1\225\2\0\2\226\50\0\25\227"+
    "\6\0\1\227\13\0\1\227\2\0\2\230\50\0\25\231"+
    "\6\0\1\231\13\0\1\231\2\0\2\232\50\0\25\233"+
    "\6\0\1\233\13\0\1\233\2\0\2\234\50\0\25\235"+
    "\6\0\1\235\13\0\1\235\2\0\2\236\50\0\25\237"+
    "\6\0\1\237\13\0\1\237\2\0\2\240\50\0\25\241"+
    "\6\0\1\241\13\0\1\241\2\0\2\242\50\0\25\243"+
    "\6\0\1\243\13\0\1\243\2\0\2\244\50\0\25\245"+
    "\6\0\1\245\13\0\1\245\2\0\2\246\50\0\25\247"+
    "\6\0\1\247\13\0\1\247\2\0\2\250\50\0\25\251"+
    "\6\0\1\251\13\0\1\251\2\0\2\252\50\0\25\253"+
    "\6\0\1\253\13\0\1\253\2\0\2\254\50\0\25\255"+
    "\6\0\1\255\13\0\1\255\2\0\2\256\50\0\25\257"+
    "\6\0\1\257\13\0\1\257\2\0\2\260\50\0\25\261"+
    "\6\0\1\261\13\0\1\261\2\0\2\262\50\0\25\263"+
    "\6\0\1\263\13\0\1\263\2\0\2\264\50\0\25\265"+
    "\6\0\1\265\13\0\1\265\2\0\2\266\50\0\25\267"+
    "\6\0\1\267\13\0\1\267\2\0\2\270\50\0\25\271"+
    "\6\0\1\271\13\0\1\271\2\0\2\272\50\0\25\273"+
    "\6\0\1\273\13\0\1\273\2\0\2\274\50\0\25\275"+
    "\6\0\1\275\13\0\1\275\2\0\2\276\50\0\25\277"+
    "\6\0\1\277\13\0\1\277\2\0\2\300\50\0\25\301"+
    "\6\0\1\301\13\0\1\301\2\0\2\302\50\0\25\303"+
    "\6\0\1\303\13\0\1\303\2\0\2\304\50\0\25\305"+
    "\6\0\1\305\13\0\1\305\2\0\2\306\50\0\25\307"+
    "\6\0\1\307\13\0\1\307\2\0\2\310\50\0\25\311"+
    "\6\0\1\311\13\0\1\311\2\0\2\312\50\0\25\313"+
    "\6\0\1\313\13\0\1\313\2\0\2\314\50\0\25\315"+
    "\6\0\1\315\13\0\1\315\2\0\2\316\50\0\25\317"+
    "\6\0\1\317\13\0\1\317\2\0\2\320\50\0\25\321"+
    "\6\0\1\321\13\0\1\321\2\0\2\322\50\0\25\323"+
    "\6\0\1\323\13\0\1\323\2\0\2\324\50\0\25\325"+
    "\6\0\1\325\13\0\1\325\2\0\2\326\50\0\25\327"+
    "\6\0\1\327\13\0\1\327\2\0\2\330\50\0\25\331"+
    "\6\0\1\331\13\0\1\331\2\0\2\332\50\0\25\333"+
    "\6\0\1\333\13\0\1\333\2\0\2\334\50\0\25\335"+
    "\6\0\1\335\13\0\1\335\2\0\2\336\50\0\25\337"+
    "\6\0\1\337\13\0\1\337\2\0\2\340\50\0\25\341"+
    "\6\0\1\341\13\0\1\341\2\0\2\342\50\0\25\343"+
    "\6\0\1\343\13\0\1\343\2\0\2\344\50\0\25\345"+
    "\6\0\1\345\13\0\1\345\2\0\2\346\50\0\25\347"+
    "\6\0\1\347\13\0\1\347\2\0\2\350\50\0\25\351"+
    "\6\0\1\351\13\0\1\351\2\0\2\352\50\0\25\353"+
    "\6\0\1\353\13\0\1\353\2\0\2\354\50\0\25\355"+
    "\6\0\1\355\13\0\1\355\2\0\2\356\50\0\25\357"+
    "\6\0\1\357\13\0\1\357\2\0\2\360\50\0\25\361"+
    "\6\0\1\361\13\0\1\361\2\0\2\362\50\0\25\363"+
    "\6\0\1\363\13\0\1\363\2\0\2\364\50\0\25\365"+
    "\6\0\1\365\13\0\1\365\2\0\2\366\50\0\25\367"+
    "\6\0\1\367\13\0\1\367\2\0\2\370\50\0\25\371"+
    "\6\0\1\371\13\0\1\371\2\0\2\372\50\0\25\373"+
    "\6\0\1\373\13\0\1\373\2\0\2\374\50\0\25\375"+
    "\6\0\1\375\13\0\1\375\2\0\2\376\50\0\25\377"+
    "\6\0\1\377\13\0\1\377\2\0\2\u0100\50\0\25\u0101"+
    "\6\0\1\u0101\13\0\1\u0101\2\0\2\u0102\50\0\25\u0103"+
    "\6\0\1\u0103\13\0\1\u0103\2\0\2\u0104\50\0\25\u0105"+
    "\6\0\1\u0105\13\0\1\u0105\2\0\2\u0106\50\0\25\u0107"+
    "\6\0\1\u0107\13\0\1\u0107\2\0\2\u0108\50\0\25\u0109"+
    "\6\0\1\u0109\13\0\1\u0109\2\0\2\u010a\50\0\25\u010b"+
    "\6\0\1\u010b\13\0\1\u010b\2\0\2\u010c\50\0\25\u010d"+
    "\6\0\1\u010d\13\0\1\u010d\2\0\2\u010e\50\0\25\u010f"+
    "\6\0\1\u010f\13\0\1\u010f\2\0\2\u0110\50\0\25\u0111"+
    "\6\0\1\u0111\13\0\1\u0111\2\0\2\u0112\50\0\25\u0113"+
    "\6\0\1\u0113\13\0\1\u0113\2\0\2\u0114\50\0\25\u0115"+
    "\6\0\1\u0115\13\0\1\u0115\2\0\2\u0116\50\0\25\u0117"+
    "\6\0\1\u0117\13\0\1\u0117\2\0\2\u0118\50\0\25\u0119"+
    "\6\0\1\u0119\13\0\1\u0119\2\0\2\u011a\50\0\25\u011b"+
    "\6\0\1\u011b\13\0\1\u011b\2\0\2\u011c\50\0\25\u011d"+
    "\6\0\1\u011d\13\0\1\u011d\2\0\2\u011e\50\0\25\u011f"+
    "\6\0\1\u011f\13\0\1\u011f\2\0\2\u0120\50\0\25\u0121"+
    "\6\0\1\u0121\13\0\1\u0121\2\0\2\u0122\50\0\25\u0123"+
    "\6\0\1\u0123\13\0\1\u0123\2\0\2\u0124\50\0\25\u0125"+
    "\6\0\1\u0125\13\0\1\u0125\2\0\2\u0126\50\0\25\u0127"+
    "\6\0\1\u0127\13\0\1\u0127\2\0\2\u0128\50\0\25\u0129"+
    "\6\0\1\u0129\13\0\1\u0129\2\0\2\u012a\50\0\25\u012b"+
    "\6\0\1\u012b\13\0\1\u012b";

  private static int [] zzUnpackTrans() {
    int [] result = new int[11004];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\20\1\11\11\31\1\4\11\1\1\1\0"+
    "\22\1\1\11\333\1\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[299];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 154) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Lexema token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return new Lexema ("ERRO: CARACTERE INVALIDO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 41: break;
          case 2: 
            { 
            } 
            // fall through
          case 42: break;
          case 3: 
            { return new Lexema("NUMERO INTEIRO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 43: break;
          case 4: 
            { return new Lexema("IDENTIFICADOR", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 44: break;
          case 5: 
            { return new Lexema("SIMBOLO DE DOIS PONTOS", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 45: break;
          case 6: 
            { return new Lexema("SIMBOLO DE VIRGULA", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 46: break;
          case 7: 
            { return new Lexema("SIMBOLO DE PONTO E VIRGULA", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 47: break;
          case 8: 
            { return new Lexema("SIMBOLO DE ABRE PARENTESES", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 48: break;
          case 9: 
            { return new Lexema("SIMBOLO DE FECHA PARENTESES", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 49: break;
          case 10: 
            { return new Lexema("SIMBOLO DE PONTO FINAL", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 50: break;
          case 11: 
            { return new Lexema("OP RELACIONAL DE IGUAL", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 51: break;
          case 12: 
            { return new Lexema("OP ARITMETICO DE ADICAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 52: break;
          case 13: 
            { return new Lexema("OP ARITMETICO DE MULTIPLICACAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 53: break;
          case 14: 
            { return new Lexema("OP ARITMETICO DE SUBTRACAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 54: break;
          case 15: 
            { return new Lexema("OP RELACIONAL DE MENOR", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 55: break;
          case 16: 
            { return new Lexema("OP RELACIONAL DE MAIORL", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 56: break;
          case 17: 
            { return new Lexema("OP LOGICO OU", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 57: break;
          case 18: 
            { return new Lexema("COMANDO SELECAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 58: break;
          case 19: 
            { return new Lexema("COMANDO REPETICAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 59: break;
          case 20: 
            { return new Lexema("OP ATRIBUICAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 60: break;
          case 21: 
            { return new Lexema("OP RELACIONAL DE MENOR OU IGUAL", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 61: break;
          case 22: 
            { return new Lexema("OP RELACIONAL DE DIFERENTE", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 62: break;
          case 23: 
            { return new Lexema("OP RELACIONAL DE MAIOR OU IGUAL", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 63: break;
          case 24: 
            { return new Lexema("COMENTARIO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 64: break;
          case 25: 
            { return new Lexema("OP LOGICO E", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 65: break;
          case 26: 
            { return new Lexema("FINAL COMANDO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 66: break;
          case 27: 
            { return new Lexema("TIPO INTEIRO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 67: break;
          case 28: 
            { return new Lexema("OP LOGICO DE NEGACAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 68: break;
          case 29: 
            { return new Lexema("OP ARITMETICO DE DIVISAO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 69: break;
          case 30: 
            { return new Lexema("DECLARACAO VARIAVEL", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 70: break;
          case 31: 
            { return new Lexema("COMANDO DE LEITURA", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 71: break;
          case 32: 
            { return new Lexema("VALOR LOGICO VERDADEIRO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 72: break;
          case 33: 
            { return new Lexema("VALOR LOGICO FALSO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 73: break;
          case 34: 
            { return new Lexema("INICIO COMANDO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 74: break;
          case 35: 
            { return new Lexema("COMANDO DE ESCRITA", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 75: break;
          case 36: 
            { return new Lexema("INICIO PROGRAMA", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 76: break;
          case 37: 
            { return new Lexema("TIPO BOOLEANO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 77: break;
          case 38: 
            { return new Lexema("DECLARACAO PROCEDIMENTO", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 78: break;
          case 39: 
            { return new Lexema("ERRO: NUMERO EXCEDE 10 DIGITOS", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 79: break;
          case 40: 
            { return new Lexema("ERRO: IDENTIFICADOR EXCEDE 20 CARACTERES", yytext(), yyline, yycolumn);
            } 
            // fall through
          case 80: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }
}
