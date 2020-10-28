public class EmbedProcess {
    
    private EmbedExtractOptions eo;
    /** Creates a new instance of EmbedProcess */
    public EmbedProcess(EmbedExtractOptions eo) {
        this.eo = eo;
    }
    
    public void startEmbed(){
        java.io.File inFile = null,outFile = null;
        java.awt.Image image = null;
        java.io.FileOutputStream dataOut = null;
        String key = null,comment = null,embedFileName = null,embeddedText=null;
        String inFile1=null, outFile1=null;
        int quality;
        
        inFile = eo.getInputFile();
        outFile = eo.createOutputFile(150);
        embedFileName = eo.getEmbedFile().getAbsolutePath();
//        image = eo.getInputImage();
        key = eo.getPassword(); //maman
        comment = eo.getComment();
        quality = eo.getQuality();
        embeddedText = eo.getEmbedText(); //encrypted data [plaindata+key]
        System.out.println("Embed Process: ET"+embeddedText+" KEY "+key); //mousomi
        inFile1 = inFile.getAbsolutePath();
        outFile1 = outFile.getAbsolutePath();
        
        
                
        try {
            dataOut = new java.io.FileOutputStream(outFile);            

            
            System.out.println("Reading Attributes Wait....");
            System.out.println("<Source - AudioFile> "+ inFile);
            System.out.println("<Output - AudioFile> "+ outFile);

            
            

			Stego hide=new Stego(inFile1,embedFileName,outFile1,embeddedText);
			
			
			if (hide.feasible) {
	  			hide.encode();
	  			System.out.println("Completed ....(EmbedProcess.java)");
	  			}	  
			else
	  			System.out.println("Error occured ....(audio.java)");	  

            
            dataOut.close();            
        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null,"Error embedding audio");
            e.printStackTrace();
        }catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,"Error embedding audio");
            e.printStackTrace();
        }
        
    }
}
