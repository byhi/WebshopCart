package client;

import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import org.tempuri.MNBArfolyamServiceSoapImpl;
import org.tempuri.MNBArfolyamServiceSoapImplLocator;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import hu.mnb.www.webservices.MNBArfolyamServiceSoap;
import hu.mnb.www.webservices.MNBArfolyamServiceSoap_GetCurrentExchangeRates_StringFault_FaultMessage;

public class MNBClient {

	MNBArfolyamServiceSoapImpl impl; 
	MNBArfolyamServiceSoap service = null;
	Double value = 0.00000 ;
	public MNBClient() {
		super();
		this.impl = new MNBArfolyamServiceSoapImplLocator();
		try {
			this.service = impl.getCustomBinding_MNBArfolyamServiceSoap();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Double getValueByCurrencyType(String currency) {
		
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = null;
		 Document document = null;
		
		 try {
			builder = factory.newDocumentBuilder();
			document  = builder.parse(new InputSource(new StringReader(this.service.getCurrentExchangeRates())));
			 
			 
			 if (document.hasChildNodes()) 
				printNote(document.getChildNodes(),currency);	
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MNBArfolyamServiceSoap_GetCurrentExchangeRates_StringFault_FaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sss = "";
		printNote(document.getChildNodes(), currency);
	/*	if (printNote(document.getChildNodes(), currency) != null) {
			
		}
		return document.hasChildNodes() ? printNote(document.getChildNodes(), currency) : null;*/
		
		System.out.println(this.value);
		return this.value;
	}
	
	private  void printNote(NodeList nodeList, String currency) {				  
				  
				  String eredmeny = null;
			    for (int count = 0; count < nodeList.getLength(); count++) {

				Node tempNode = nodeList.item(count);				
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {					
					if (tempNode.hasAttributes()) {

						NamedNodeMap nodeMap = tempNode.getAttributes();
						
						for (int i = 0; i < nodeMap.getLength(); i++) {

							if (nodeMap.item(i).getNodeValue().equals(currency) && tempNode.getTextContent()!= null) {
								//eredmeny = tempNode.getTextContent();
								this.value = Double.parseDouble(tempNode.getTextContent().replace(",","."));
							}
						}
					} 

					if (tempNode.hasChildNodes()) {
						printNote(tempNode.getChildNodes(),currency);
						}				
				  }
			    }		
			   // System.out.println(eredmeny);
			   //return eredmeny;
			  }
	
}
