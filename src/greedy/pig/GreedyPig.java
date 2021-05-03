
package greedy.pig;

import java.util.Scanner;


public class GreedyPig {

//Greedy pig
//
//    Zaidziama su vienu kauliuku 1..6
//
//    Tikslas surinkti 100 tasku.
//
//    zaidejas meta
//        jei isrideno 2..6 gali ridenti dar karta
//        jei isrideno 1 - to ejimo taskai nunulinami ir ejimas pereina kitam zaidejui
//      zaidejas (jei isrideno 2..6) gali pasirinkti ar mesti dar karta
//      ar pasiimti taskus ir perleisti eima kitam zaidejui
//
//    Z1          Z2
//    10  10      0  0
//    8   18      23 23
//    0   18      9  32
//
//    Z1:
//    isrideno 3
//    isrideno 5
//    isrideno 2
//    stop
//
//    Z2:
//    isrideno 6
//    isrideno 1
//
//    Z1:
//    isrideno 4
//    isrideno 4
//    stop
//
//    Z2:
//    isrideno 6
//    isrideno 5
//    isrideno 6
//    isrideno 6
//    stop
//
//    Z1:
//    isrideno 1
//
//    Z2:
//    isrideno 3
//    isrideno 2
//    isrideno 4
//    stop
// 
//    kol kuris nors is zaideju surenka 100
//
//
//    Leisti zmogui pasirinkti ar reidenti ar sustoti
//
//    Kompiuteris zaidzia:
//    1. bando isridenti 5 kartus is eiles
//    ***
//    2. bando pasiekti 18 tasku
//
//    ***************
//    Tegu zaidzia kompiuteris su savim - 2 skirtingos strategijos
//
//    comp1: 4 3 6 2 3 = 18 (18)
//    comp2: 6 5 6 1 = 0 (0)
//    comp1: 1 = 0 (18)
//    comp2: 4 5 6 2 2 = 19 (19)
//    comp1: 3 3 3 3 3 = 15 (33)
//    ...
//    */
    
//  PIRMA ZAIDIMO VERSIJA
//------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int z1Suma = 0;
        int z2Suma = 0;
        int z2RidenimoSuma = 0;
        boolean z1Eile = true;
        boolean z2Eile = false;
        
        while(z1Suma < 100 && z2Suma < 100){
            
            
            if(z1Eile){
                int ridenimoSk = 0;
                int ridenimoSuma = 0;
                
                System.out.println();
                System.out.println("ZAIDEJO 1 EILE");
                
                while(ridenimoSk < 6){
                    
                    System.out.println("Ridenti iveskite: 1");
                    System.out.println("Sustoti iveskite: 0");
                    int atsakymas = sc.nextInt();

                    if(atsakymas == 1){
                        int kauliukas = (int)(Math.random() * 6) + 1 ;
                        System.out.println("isridenote: " + kauliukas);
                        System.out.println();
                        
                        if(kauliukas == 1){
                            ridenimoSuma = 0;
                            ridenimoSk = 6;
                        } else {
                            ridenimoSuma += kauliukas; 
                            ridenimoSk++;
                        }

                    } else if (atsakymas == 0){
                        ridenimoSk = 6;
                    }
                }
                z2Eile = true;
                        z1Eile = false;
                z1Suma += ridenimoSuma;
                System.out.println("Zaidejo 1 tasku suma: " + z1Suma);
            } 
            
            if(z2Eile){
                int ridenimoSk = 0;
                int ridenimoSuma = 0;
                
                System.out.println();
                System.out.println("ZAIDEJO 2 EILE");
                
                while(ridenimoSk < 6){
                    
                    System.out.println("Ridenti iveskite: 1");
                    System.out.println("Sustoti iveskite: 0");
                    int atsakymas = sc.nextInt();

                    if(atsakymas == 1){
                        int kauliukas = (int)(Math.random() * 6) + 1 ;
                        System.out.println("isridenote: " + kauliukas);
                        System.out.println();
                        
                        if(kauliukas == 1){
                            ridenimoSuma = 0;

                            ridenimoSk = 6;
                        } else {
                            ridenimoSuma += kauliukas; 
                            ridenimoSk++;
                        }

                    } else if (atsakymas == 0){
                        ridenimoSk = 6;
                    }
                }
                z1Eile = true;
                z2Eile = false;
                z2Suma += ridenimoSuma;
                System.out.println("Zaidejo 2 tasku suma: " + z2Suma);
            } 
        }
        
        System.out.println();
        System.out.println("ZAIDIMAS BAIGTAS");
        if(z1Suma > z2Suma){
            System.out.println("Zaidejas 1 laimejo!!! Su " + z1Suma + " taskais");
        } else if (z1Suma < z2Suma){
            System.out.println("Zaidejas 2 laimejo!!! Su " + z2Suma + " taskais");
        } else {
            System.out.println("Lygiosios!!! Abu zaidejai surinko " + z2Suma + " taskus");
        }
        
    }
 
    
    
//    Leisti zmogui pasirinkti ar reidenti ar sustoti
    
//    Kompiuteris zaidzia:
//    1. bando isridenti 5 kartus is eiles
   
    
////  ANTRA ZAIDIMO VERSIJA (su kompiuteriu)
////------------------------------------------------------------------------------
//public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        
//        int zSuma = 0;
//        int kSuma = 0;
//        boolean zEile = true;
//        boolean kEile = false;
//        
//        while(zSuma < 100 && kSuma < 100){
//            
//            
//            if(zEile){
//                int ridenimoSk = 0;
//                int ridenimoSuma = 0;
//                
//                System.out.println();
//                System.out.println("JUSU EILE");
//                
//                while(ridenimoSk < 6){
//                    
//                    System.out.println("Ridenti iveskite: 1");
//                    System.out.println("Sustoti iveskite: 0");
//                    int atsakymas = sc.nextInt();
//
//                    if(atsakymas == 1){
//                        int kauliukas = (int)(Math.random() * 6) + 1 ;
//                        System.out.println("isridenote: " + kauliukas);
//                        System.out.println();
//                        
//                        if(kauliukas == 1){
//                            ridenimoSuma = 0;
//                            kEile = true;
//                            zEile = false;
//                            ridenimoSk = 6;
//                        } else {
//                            ridenimoSuma += kauliukas; 
//                            ridenimoSk++;
//                        }
//
//                    } else if (atsakymas == 0){
//                        kEile = true;
//                        zEile = false;
//                        ridenimoSk = 6;
//                    }
//                }
//                zSuma += ridenimoSuma;
//                System.out.println("Jusu tasku suma: " + zSuma);
//            } 
//            
//            if(kEile){
//                int ridenimoSk = 0;
//                int ridenimoSuma = 0;
//                
//                System.out.println();
//                System.out.println("KOMPIUTERIO EILE");
//                
//                while(ridenimoSk < 5){
//                    
//                    int kauliukas = (int)(Math.random() * 6) + 1 ;
//                    System.out.println("kompiuteris isrideno: " + kauliukas);
//                    System.out.println();
//
//                    if(kauliukas == 1){
//                        ridenimoSuma = 0;
//                        zEile = true;
//                        kEile = false;
//                        ridenimoSk = 6;
//                    } else {
//                        ridenimoSuma += kauliukas; 
//                        ridenimoSk++;
//                    }
//
//                }
//                zEile = true;
//                kEile = false;
//                kSuma += ridenimoSuma;
//                System.out.println("Kompiuterio tasku suma: " + kSuma);
//            } 
//        }
//        
//        System.out.println();
//        System.out.println("ZAIDIMAS BAIGTAS");
//        if(zSuma > kSuma){
//            System.out.println("Jus laimejote!!! Su " + zSuma + " taskais");
//        } else if (zSuma < kSuma){
//            System.out.println("Kompiuteris laimejo!!! Su " + kSuma + " taskais");
//        } else {
//            System.out.println("Lygiosios!!! Jus abu surinkote " + zSuma + " taskus");
//        }
//        
//    }    
    
//    ***
//    2. bando pasiekti 18 tasku
//

//  TRECIA ZAIDIMO VERSIJA (su kompiuteriu)
//------------------------------------------------------------------------------
//public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        
//        int zSuma = 0;
//        int kSuma = 0;
//        boolean zEile = true;
//        boolean kEile = false;
//        
//        while(zSuma < 100 && kSuma < 100){
//            
//            
//            if(zEile){
//                int ridenimoSk = 0;
//                int ridenimoSuma = 0;
//                
//                System.out.println();
//                System.out.println("JUSU EILE");
//                
//                while(ridenimoSk < 6){
//                    
//                    System.out.println("Ridenti iveskite: 1");
//                    System.out.println("Sustoti iveskite: 0");
//                    int atsakymas = sc.nextInt();
//
//                    if(atsakymas == 1){
//                        int kauliukas = (int)(Math.random() * 6) + 1 ;
//                        System.out.println("isridenote: " + kauliukas);
//                        System.out.println();
//                        
//                        if(kauliukas == 1){
//                            ridenimoSuma = 0;
//                            kEile = true;
//                            zEile = false;
//                            ridenimoSk = 6;
//                        } else {
//                            ridenimoSuma += kauliukas; 
//                            ridenimoSk++;
//                        }
//
//                    } else if (atsakymas == 0){
//                        kEile = true;
//                        zEile = false;
//                        ridenimoSk = 6;
//                    }
//                }
//                zSuma += ridenimoSuma;
//                System.out.println("Jusu tasku suma: " + zSuma);
//            } 
//            
//            if(kEile){
//                int ridenimoSk = 0;
//                int ridenimoSuma = 0;
//                boolean bando = true;
//                
//                System.out.println();
//                System.out.println("KOMPIUTERIO EILE");
//                
//                while(bando){
//                    
//                    int kauliukas = (int)(Math.random() * 6) + 1 ;
//                    System.out.println("kompiuteris isrideno: " + kauliukas);
//                    System.out.println();
//
//                    if(kauliukas == 1){
//                        ridenimoSuma = 0;
//                        bando = false;
//                    } else {
//                        ridenimoSuma += kauliukas; 
//                        ridenimoSk++;
//                    }
//                    if(ridenimoSuma >= 18){
//                        bando = false;
//                    }
//
//                }
//                zEile = true;
//                kEile = false;
//                kSuma += ridenimoSuma;
//                System.out.println("Kompiuterio tasku suma: " + kSuma);
//            } 
//        }
//        
//        System.out.println();
//        System.out.println("ZAIDIMAS BAIGTAS");
//        if(zSuma > kSuma){
//            System.out.println("Jus laimejote!!! Su " + zSuma + " taskais");
//        } else if (zSuma < kSuma){
//            System.out.println("Kompiuteris laimejo!!! Su " + kSuma + " taskais");
//        } else {
//            System.out.println("Lygiosios!!! Jus abu surinkote " + zSuma + " taskus");
//        }
//        
//    }
    
 //    ***************
//    Tegu zaidzia kompiuteris su savim - 2 skirtingos strategijos
//
//    comp1: 4 3 6 2 3 = 18 (18)
//    comp2: 6 5 6 1 = 0 (0)
//    comp1: 1 = 0 (18)
//    comp2: 4 5 6 2 2 = 19 (19)
//    comp1: 3 3 3 3 3 = 15 (33)
//    ...    
////  KETVIRTA ZAIDIMO VERSIJA (kompiuteris su kompiuteriu)
////------------------------------------------------------------------------------
//public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        
//        int k1Suma = 0;
//        int k2Suma = 0;
//        boolean k1Eile = true;
//        boolean k2Eile = false;
//        
//        while(k1Suma < 100 && k2Suma < 100){
//            
//            
//            if(k1Eile){
//                int ridenimoSk = 0;
//                int ridenimoSuma = 0;
//                
//                System.out.println();
//                System.out.println("K1 EILE");
//                
//                while(ridenimoSk < 5){
//                    
//                    int kauliukas = (int)(Math.random() * 6) + 1 ;
//                    System.out.println("k1 isrideno: " + kauliukas);
//                    System.out.println();
//
//                    if(kauliukas == 1){
//                        ridenimoSuma = 0;
//                        ridenimoSk = 6;
//                    } else {
//                        ridenimoSuma += kauliukas; 
//                        ridenimoSk++;
//                    }
//
//                }
//                k2Eile = true;
//                k1Eile = false;
//                k1Suma += ridenimoSuma;
//                System.out.println("Kompiuterio tasku suma: " + k1Suma);
//            } 
//            
//            if(k2Eile){
//                int ridenimoSk = 0;
//                int ridenimoSuma = 0;
//                boolean bando = true;
//                
//                System.out.println();
//                System.out.println("K2 EILE");
//                
//                while(bando){
//                    
//                    int kauliukas = (int)(Math.random() * 6) + 1 ;
//                    System.out.println("k2 isrideno: " + kauliukas);
//                    System.out.println();
//
//                    if(kauliukas == 1){
//                        ridenimoSuma = 0;
//                        bando = false;
//                    } else {
//                        ridenimoSuma += kauliukas; 
//                        ridenimoSk++;
//                    }
//                    if(ridenimoSuma >= 18){
//                        bando = false;
//                    }
//
//                }
//                k1Eile = true;
//                k2Eile = false;
//                k2Suma += ridenimoSuma;
//                System.out.println("Kompiuterio tasku suma: " + k2Suma);
//            }  
//        }
//        
//        System.out.println();
//        System.out.println("ZAIDIMAS BAIGTAS");
//        if(k1Suma > k2Suma){
//            System.out.println("Kompiuteris 1 laimejo!!! Su " + k1Suma + " taskais");
//        } else if (k1Suma < k2Suma){
//            System.out.println("Kompiuteris 2 laimejo!!! Su " + k2Suma + " taskais");
//        } else {
//            System.out.println("Lygiosios!!! Jus abu kompiuteriai surinko " + k2Suma + " taskus");
//        }
//        
//    }    
}
