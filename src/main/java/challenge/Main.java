package challenge;
//package com.mkyong.csv;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {


	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public static int q1() {
		String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
		String line = "";
        String cvsSplitBy = ",";

        List<String> allCountries = new ArrayList<String>();
        int aux = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	aux +=1;
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if ( allCountries.contains(country[14]) == false ) {
                	allCountries.add(country[14]);         
                }

                //System.out.println("Country [code= " + country[14] + " , name=" + country[13] + "]");             

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		


        //System.out.println(aux);
        //System.out.println(allCountries.size());

		return (allCountries.size()-1);
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public static int q2() {
		String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
		String line = "";
        String cvsSplitBy = ",";

        List<String> allClubs = new ArrayList<String>();
        int aux = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	aux +=1;
                // use comma as separator
                String[] club = line.split(cvsSplitBy);
                if ( ( allClubs.contains(club[3]) == false ) && ( !club[3].isEmpty() ) ) {
                	allClubs.add(club[3]);  
                    //System.out.println("Country [code= " + club[3] + " , name=" + club[0] + "]");
                }            

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


		return (allClubs.size() - 1);
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public static List<String> q3() {
		List<String> list = new ArrayList<String>();
		String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
		String line = "";
        String cvsSplitBy = ",";

        List<String> full_name = new ArrayList<String>();
        int aux = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null && (aux <= 20) ) {
            	aux +=1;
                // use comma as separator
                String[] nome = line.split(cvsSplitBy); 
                if ( ( full_name.contains(nome[2]) == false ) && ( aux > 1 ) ) {
                	full_name.add(nome[2]);        
                if (aux > 1) {
                	//System.out.println("Country [code= " + nome[0] + " , name=" + nome[2] + "]");
                }
                }            

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(full_name.size());
		return full_name;
		
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` [2] e `eur_release_clause` [18])
	public static List<String> q4() {
		List<String> list = new ArrayList<String>();
		String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
		String line = "";
        String cvsSplitBy = ",";

        List<String> rec = new ArrayList<String>();
        double[] maiorRecisao =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] nomes =  {"", "", "", "", "", "", "", "", "", ""};
        int aux = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if (aux > 0) {
                    // use comma as separator
                    String[] recisao = line.split(cvsSplitBy); 
                    //System.out.println(recisao[18]);
                    if (!recisao[18].isEmpty()) {
                        double valor = Double.parseDouble(recisao[18]);
                        for (int i=0; i<10; i++) {
                        	if (valor > maiorRecisao[i]) {
                        		//fazer sort
                        		int aux2=0;
                        		for (int j=8; j>=i; j--) {
                        			maiorRecisao[j+1] = maiorRecisao[j];    
                        			nomes[j+1] = nomes[j];
                        		}
                        		maiorRecisao[i] = valor;  
                        		nomes[i] = recisao[2];
                        		break;
                        	}      	
                        }                     	
                    }
           		
            		
            	}
    
                            
                aux +=1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < 10; i++) {
        	rec.add( nomes[i] );
        }
        
        

       // System.out.println(rec);
		return rec;
		
	}
	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public static List<String> q5() {
		List<String> list = new ArrayList<String>();

		String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
		String line = "";
        String cvsSplitBy = ",";

        List<String> full_name = new ArrayList<String>();		
        List<String> idade = new ArrayList<String>();
        int[] maiorIdade =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        String[] dataNasc =  {"9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99", "9999-99-99"};
        String[] nomes =  {"", "", "", "", "", "", "", "", "", ""};
        double[] eur_wage =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int aux = 0;
   
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	if (aux > 0) {
                    // use comma as separator
                    String[] dados = line.split(cvsSplitBy); 
                    //System.out.println(dados[6]);
                    String mesNasc = dados[8]; 
                    double salario = Double.parseDouble(dados[17]);
                    //System.out.println(dados[8].substring(8,10));
                    int mes = Integer.parseInt(mesNasc.substring(5,7));
                    int dia = Integer.parseInt(mesNasc.substring(8,10));
                    int ano = Integer.parseInt(mesNasc.substring(0,4));
                    if (true) {
                        int valor = Integer.parseInt(dados[6]);
                        for (int i=0; i<10; i++) {	
                        	if (ano < Integer.parseInt(dataNasc[i].substring(0,4))) {                       		
                        				//fazer sort
                        				int aux2=0;
                        					for (int j=8; j>=i; j--) {
                        						maiorIdade[j+1] = maiorIdade[j];    
                        						nomes[j+1] = nomes[j];
                        						dataNasc[j+1] = dataNasc[j];
                        						eur_wage[j+1] = eur_wage[j];
                        					}
                        					maiorIdade[i] = valor;  
                        					nomes[i] = dados[2];
                        					dataNasc[i] = dados[8];
                        					eur_wage[i] = salario;
                        					break;
                        		
                        	}  
                        	else if ((ano == Integer.parseInt(dataNasc[i].substring(0,4))) && (mes < Integer.parseInt(dataNasc[i].substring(5,7))) ) {
            					for (int j=8; j>=i; j--) {
            						maiorIdade[j+1] = maiorIdade[j];    
            						nomes[j+1] = nomes[j];
            						dataNasc[j+1] = dataNasc[j];
            						eur_wage[j+1] = eur_wage[j];
            					}
            					maiorIdade[i] = valor;  
            					nomes[i] = dados[2];
            					dataNasc[i] = dados[8];
            					eur_wage[i] = salario;
            					break;                        		
	
                        	}
                        	else if ((ano == Integer.parseInt(dataNasc[i].substring(0,4))) && (mes == Integer.parseInt(dataNasc[i].substring(5,7))) && (dia < Integer.parseInt(dataNasc[i].substring(8,10))) ) {
            					for (int j=8; j>=i; j--) {
            						maiorIdade[j+1] = maiorIdade[j];    
            						nomes[j+1] = nomes[j];
            						dataNasc[j+1] = dataNasc[j];
            						eur_wage[j+1] = eur_wage[j];
            					}
            					maiorIdade[i] = valor;  
            					nomes[i] = dados[2];
            					dataNasc[i] = dados[8];
            					eur_wage[i] = salario;
            					break;                        		
	
                        	}   
                        	else if ((ano == Integer.parseInt(dataNasc[i].substring(0,4))) && (mes == Integer.parseInt(dataNasc[i].substring(5,7))) && (dia == Integer.parseInt(dataNasc[i].substring(8,10))) ) {
            					
                        		if (salario >  eur_wage[i]) {
                        			int k = i;
                        			int aux3 = 0;
                        			while (maiorIdade[k] == maiorIdade[k+1]) {
                        				aux3++;
                        				k++;
                        			}
                        			
                        			//for(int l=i; l>=i+aux3-2; l++)
                        			for(int l=i+aux3-2; l>=i; l--) {
                        				maiorIdade[l+1] = maiorIdade[l]; 
                        				nomes[l+1] = nomes[l];
                        				dataNasc[l+1] = dataNasc[l];
                        				eur_wage[l+1] = eur_wage[l];
                        			}
                     		
                					maiorIdade[i] = valor;  
                					nomes[i] = dados[2];
                					dataNasc[i] = dados[8];
                					eur_wage[i] = salario;
                					break;                          			
                         			
                        		}
                      		
	
                        	}
                        	
                        }                     	
                    }       		
            		
            	}           
                aux +=1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
        for (int i = 0; i < 10; i++) {
        	full_name.add(nomes[i]);
        }
        
        System.out.println(full_name);
		return full_name;
		
	}



	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public static Map<Integer, Integer> q6() {
		Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		
		
		
		String csvFile = "/home/casper/codenation/java-3/src/main/resources/data.csv";
		String line = "";
        String cvsSplitBy = ",";
        
        int[] idade = new int[50];
        int[] qtd = new int[50];

        List<String> allCountries = new ArrayList<String>();
        int aux = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(aux>0) {
            		
                // use comma as separator
                String[] dados = line.split(cvsSplitBy);
                String aj = dados[6];
                int age = Integer.parseInt(aj);
                qtd[age] += 1;
                //qtd[47] += 1;
                
            	}
                aux +=1;               
                

                //System.out.println("Country [code= " + country[14] + " , name=" + country[13] + "]");             

            }

        } catch (IOException e) {
            e.printStackTrace();
        }		
		
        for (int i=0; i<50; i++) {
        	if (qtd[i] != 0) {
        		mapa.put(i, qtd[i]);
        	}
        	
        }

		return mapa;
	}


}
