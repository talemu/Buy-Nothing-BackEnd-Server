//package main;
//
//public class RestFulApiWebHolder {
//	<?xml version="1.0" encoding="UTF-8"?>
//	<wsdl:definitions targetNamespace="http://DefaultNamespace" xmlns:apachesoap="http://xml.apache.org/xml-soap" xmlns:impl="http://DefaultNamespace" xmlns:intf="http://DefaultNamespace" xmlns:tns1="http://util.java" xmlns:tns2="http://core.rs.ws.jakarta" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
//	<!--WSDL created by Apache Axis version: 1.4
//	Built on Apr 22, 2006 (06:55:48 PDT)-->
//	 <wsdl:types>
//	  <complexType elementFormDefault="qualified" targetNamespace="http://DefaultNamespace" xmlns="http://www.w3.org/2001/XMLSchema">
//	   <import namespace="http://core.rs.ws.jakarta"/>
//	   <import namespace="http://util.java"/>
//	   <element name="getAllGives">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="xsd:anyType"/>
//	      <element name="tf" type="xsd:boolean"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getAllGivesResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getAllGivesReturn" type="xsd:anyType"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createThank">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createThankResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="createThankReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchGive">
//	    <complexType>
//	     <sequence>
//	      <element name="substring" type="xsd:string"/>
//	      <element name="date1" type="xsd:string"/>
//	      <element name="date2" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchGiveResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="searchGiveReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getMyGives">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="tf" type="xsd:boolean"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getMyGivesResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getMyGivesReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewGive">
//	    <complexType>
//	     <sequence>
//	      <element name="gid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewGiveResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="viewGiveReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getAllThanks">
//	    <complexType/>
//	   </element>
//	   <element name="getAllThanksResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getAllThanksReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewThank">
//	    <complexType>
//	     <sequence>
//	      <element name="tid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewThankResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="viewThankReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getMyThanks">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getMyThanksResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getMyThanksReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateThank">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="tid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateThankResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="updateThankReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewThanksForUser">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewThanksForUserResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="viewThanksForUserReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchThanks">
//	    <complexType>
//	     <sequence>
//	      <element name="substring" type="xsd:string"/>
//	      <element name="date1" type="xsd:string"/>
//	      <element name="date2" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchThanksResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="searchThanksReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewNote">
//	    <complexType>
//	     <sequence>
//	      <element name="nid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewNoteResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="viewNoteReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createNote">
//	    <complexType>
//	     <sequence>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createNoteResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="createNoteReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteNote">
//	    <complexType>
//	     <sequence>
//	      <element name="nid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteNoteResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="deleteNoteReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateNote">
//	    <complexType>
//	     <sequence>
//	      <element name="nid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateNoteResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="updateNoteReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchNote">
//	    <complexType>
//	     <sequence>
//	      <element name="substring" type="xsd:string"/>
//	      <element name="date1" type="xsd:string"/>
//	      <element name="date2" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchNoteResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="searchNoteReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createAccount">
//	    <complexType>
//	     <sequence>
//	      <element name="uriInfo" type="xsd:anyType"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createAccountResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="createAccountReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteAccount">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteAccountResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="deleteAccountReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="activateAccount">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="activateAccountResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="activateAccountReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateAccount">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateAccountResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="updateAccountReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getAllAccounts">
//	    <complexType/>
//	   </element>
//	   <element name="getAllAccountsResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getAllAccountsReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewAccount">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewAccountResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="viewAccountReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateAsk">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="aid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateAskResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="updateAskReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createAsk">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createAskResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="createAskReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteAsk">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="aid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteAskResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="deleteAskReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deactivateAsk">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="aid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deactivateAskResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="deactivateAskReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getMyAsks">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="tf" type="xsd:boolean"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getMyAsksResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getMyAsksReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchAccount">
//	    <complexType>
//	     <sequence>
//	      <element name="substring" type="xsd:string"/>
//	      <element name="date1" type="xsd:string"/>
//	      <element name="date2" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchAccountResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="searchAccountReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createGive">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="createGiveResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="createGiveReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchAsk">
//	    <complexType>
//	     <sequence>
//	      <element name="substring" type="xsd:string"/>
//	      <element name="date1" type="xsd:string"/>
//	      <element name="date2" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="searchAskResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="searchAskReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteGive">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="gid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deleteGiveResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="deleteGiveReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewAsk">
//	    <complexType>
//	     <sequence>
//	      <element name="aid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="viewAskResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="viewAskReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deactivateGive">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="gid" type="tns1:UUID"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="deactivateGiveResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="deactivateGiveReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateGive">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="gid" type="tns1:UUID"/>
//	      <element name="json" type="xsd:string"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="updateGiveResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="updateGiveReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getAllAsks">
//	    <complexType>
//	     <sequence>
//	      <element name="uid" type="tns1:UUID"/>
//	      <element name="tf" type="xsd:boolean"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	   <element name="getAllAsksResponse">
//	    <complexType>
//	     <sequence>
//	      <element name="getAllAsksReturn" type="tns2:Response"/>
//	     </sequence>
//	    </complexType>
//	   </element>
//	  </complexType>
//	 </wsdl:types>
//
//	   <wsdl:message name="deleteAskResponse">
//
//	      <wsdl:part element="impl:deleteAskResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteAccountResponse">
//
//	      <wsdl:part element="impl:deleteAccountResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchAskRequest">
//
//	      <wsdl:part element="impl:searchAsk" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewGiveRequest">
//
//	      <wsdl:part element="impl:viewGive" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchThanksResponse">
//
//	      <wsdl:part element="impl:searchThanksResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createGiveRequest">
//
//	      <wsdl:part element="impl:createGive" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewGiveResponse">
//
//	      <wsdl:part element="impl:viewGiveResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllAccountsRequest">
//
//	      <wsdl:part element="impl:getAllAccounts" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateGiveResponse">
//
//	      <wsdl:part element="impl:updateGiveResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllGivesResponse">
//
//	      <wsdl:part element="impl:getAllGivesResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewNoteRequest">
//
//	      <wsdl:part element="impl:viewNote" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchAccountResponse">
//
//	      <wsdl:part element="impl:searchAccountResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllAsksRequest">
//
//	      <wsdl:part element="impl:getAllAsks" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deactivateGiveResponse">
//
//	      <wsdl:part element="impl:deactivateGiveResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteAccountRequest">
//
//	      <wsdl:part element="impl:deleteAccount" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateAccountRequest">
//
//	      <wsdl:part element="impl:updateAccount" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewAccountResponse">
//
//	      <wsdl:part element="impl:viewAccountResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllAccountsResponse">
//
//	      <wsdl:part element="impl:getAllAccountsResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateGiveRequest">
//
//	      <wsdl:part element="impl:updateGive" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchAccountRequest">
//
//	      <wsdl:part element="impl:searchAccount" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllThanksResponse">
//
//	      <wsdl:part element="impl:getAllThanksResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchNoteResponse">
//
//	      <wsdl:part element="impl:searchNoteResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createThankResponse">
//
//	      <wsdl:part element="impl:createThankResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllThanksRequest">
//
//	      <wsdl:part element="impl:getAllThanks" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateAskResponse">
//
//	      <wsdl:part element="impl:updateAskResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllAsksResponse">
//
//	      <wsdl:part element="impl:getAllAsksResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchGiveResponse">
//
//	      <wsdl:part element="impl:searchGiveResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewThankRequest">
//
//	      <wsdl:part element="impl:viewThank" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createNoteRequest">
//
//	      <wsdl:part element="impl:createNote" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewAskRequest">
//
//	      <wsdl:part element="impl:viewAsk" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateNoteRequest">
//
//	      <wsdl:part element="impl:updateNote" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchThanksRequest">
//
//	      <wsdl:part element="impl:searchThanks" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteNoteRequest">
//
//	      <wsdl:part element="impl:deleteNote" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchAskResponse">
//
//	      <wsdl:part element="impl:searchAskResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="activateAccountResponse">
//
//	      <wsdl:part element="impl:activateAccountResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateThankRequest">
//
//	      <wsdl:part element="impl:updateThank" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createAskResponse">
//
//	      <wsdl:part element="impl:createAskResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getAllGivesRequest">
//
//	      <wsdl:part element="impl:getAllGives" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getMyThanksRequest">
//
//	      <wsdl:part element="impl:getMyThanks" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateAskRequest">
//
//	      <wsdl:part element="impl:updateAsk" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateThankResponse">
//
//	      <wsdl:part element="impl:updateThankResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deactivateAskRequest">
//
//	      <wsdl:part element="impl:deactivateAsk" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createAccountRequest">
//
//	      <wsdl:part element="impl:createAccount" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateNoteResponse">
//
//	      <wsdl:part element="impl:updateNoteResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getMyThanksResponse">
//
//	      <wsdl:part element="impl:getMyThanksResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewNoteResponse">
//
//	      <wsdl:part element="impl:viewNoteResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deactivateGiveRequest">
//
//	      <wsdl:part element="impl:deactivateGive" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="activateAccountRequest">
//
//	      <wsdl:part element="impl:activateAccount" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createThankRequest">
//
//	      <wsdl:part element="impl:createThank" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createGiveResponse">
//
//	      <wsdl:part element="impl:createGiveResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getMyGivesRequest">
//
//	      <wsdl:part element="impl:getMyGives" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createAccountResponse">
//
//	      <wsdl:part element="impl:createAccountResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="updateAccountResponse">
//
//	      <wsdl:part element="impl:updateAccountResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewAskResponse">
//
//	      <wsdl:part element="impl:viewAskResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getMyAsksRequest">
//
//	      <wsdl:part element="impl:getMyAsks" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getMyGivesResponse">
//
//	      <wsdl:part element="impl:getMyGivesResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteGiveRequest">
//
//	      <wsdl:part element="impl:deleteGive" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createAskRequest">
//
//	      <wsdl:part element="impl:createAsk" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteGiveResponse">
//
//	      <wsdl:part element="impl:deleteGiveResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchNoteRequest">
//
//	      <wsdl:part element="impl:searchNote" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewThanksForUserResponse">
//
//	      <wsdl:part element="impl:viewThanksForUserResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewAccountRequest">
//
//	      <wsdl:part element="impl:viewAccount" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewThankResponse">
//
//	      <wsdl:part element="impl:viewThankResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteNoteResponse">
//
//	      <wsdl:part element="impl:deleteNoteResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="getMyAsksResponse">
//
//	      <wsdl:part element="impl:getMyAsksResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deleteAskRequest">
//
//	      <wsdl:part element="impl:deleteAsk" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="viewThanksForUserRequest">
//
//	      <wsdl:part element="impl:viewThanksForUser" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="createNoteResponse">
//
//	      <wsdl:part element="impl:createNoteResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="deactivateAskResponse">
//
//	      <wsdl:part element="impl:deactivateAskResponse" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:message name="searchGiveRequest">
//
//	      <wsdl:part element="impl:searchGive" name="parameters">
//
//	      </wsdl:part>
//
//	   </wsdl:message>
//
//	   <wsdl:portType name="RestFul_Controller_BN">
//
//	      <wsdl:operation name="getAllGives">
//
//	         <wsdl:input message="impl:getAllGivesRequest" name="getAllGivesRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getAllGivesResponse" name="getAllGivesResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createThank">
//
//	         <wsdl:input message="impl:createThankRequest" name="createThankRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:createThankResponse" name="createThankResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchGive">
//
//	         <wsdl:input message="impl:searchGiveRequest" name="searchGiveRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:searchGiveResponse" name="searchGiveResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getMyGives">
//
//	         <wsdl:input message="impl:getMyGivesRequest" name="getMyGivesRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getMyGivesResponse" name="getMyGivesResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewGive">
//
//	         <wsdl:input message="impl:viewGiveRequest" name="viewGiveRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:viewGiveResponse" name="viewGiveResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getAllThanks">
//
//	         <wsdl:input message="impl:getAllThanksRequest" name="getAllThanksRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getAllThanksResponse" name="getAllThanksResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewThank">
//
//	         <wsdl:input message="impl:viewThankRequest" name="viewThankRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:viewThankResponse" name="viewThankResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getMyThanks">
//
//	         <wsdl:input message="impl:getMyThanksRequest" name="getMyThanksRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getMyThanksResponse" name="getMyThanksResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateThank">
//
//	         <wsdl:input message="impl:updateThankRequest" name="updateThankRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:updateThankResponse" name="updateThankResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewThanksForUser">
//
//	         <wsdl:input message="impl:viewThanksForUserRequest" name="viewThanksForUserRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:viewThanksForUserResponse" name="viewThanksForUserResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchThanks">
//
//	         <wsdl:input message="impl:searchThanksRequest" name="searchThanksRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:searchThanksResponse" name="searchThanksResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewNote">
//
//	         <wsdl:input message="impl:viewNoteRequest" name="viewNoteRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:viewNoteResponse" name="viewNoteResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createNote">
//
//	         <wsdl:input message="impl:createNoteRequest" name="createNoteRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:createNoteResponse" name="createNoteResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteNote">
//
//	         <wsdl:input message="impl:deleteNoteRequest" name="deleteNoteRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:deleteNoteResponse" name="deleteNoteResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateNote">
//
//	         <wsdl:input message="impl:updateNoteRequest" name="updateNoteRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:updateNoteResponse" name="updateNoteResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchNote">
//
//	         <wsdl:input message="impl:searchNoteRequest" name="searchNoteRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:searchNoteResponse" name="searchNoteResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createAccount">
//
//	         <wsdl:input message="impl:createAccountRequest" name="createAccountRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:createAccountResponse" name="createAccountResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteAccount">
//
//	         <wsdl:input message="impl:deleteAccountRequest" name="deleteAccountRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:deleteAccountResponse" name="deleteAccountResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="activateAccount">
//
//	         <wsdl:input message="impl:activateAccountRequest" name="activateAccountRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:activateAccountResponse" name="activateAccountResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateAccount">
//
//	         <wsdl:input message="impl:updateAccountRequest" name="updateAccountRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:updateAccountResponse" name="updateAccountResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getAllAccounts">
//
//	         <wsdl:input message="impl:getAllAccountsRequest" name="getAllAccountsRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getAllAccountsResponse" name="getAllAccountsResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewAccount">
//
//	         <wsdl:input message="impl:viewAccountRequest" name="viewAccountRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:viewAccountResponse" name="viewAccountResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateAsk">
//
//	         <wsdl:input message="impl:updateAskRequest" name="updateAskRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:updateAskResponse" name="updateAskResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createAsk">
//
//	         <wsdl:input message="impl:createAskRequest" name="createAskRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:createAskResponse" name="createAskResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteAsk">
//
//	         <wsdl:input message="impl:deleteAskRequest" name="deleteAskRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:deleteAskResponse" name="deleteAskResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deactivateAsk">
//
//	         <wsdl:input message="impl:deactivateAskRequest" name="deactivateAskRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:deactivateAskResponse" name="deactivateAskResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getMyAsks">
//
//	         <wsdl:input message="impl:getMyAsksRequest" name="getMyAsksRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getMyAsksResponse" name="getMyAsksResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchAccount">
//
//	         <wsdl:input message="impl:searchAccountRequest" name="searchAccountRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:searchAccountResponse" name="searchAccountResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createGive">
//
//	         <wsdl:input message="impl:createGiveRequest" name="createGiveRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:createGiveResponse" name="createGiveResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchAsk">
//
//	         <wsdl:input message="impl:searchAskRequest" name="searchAskRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:searchAskResponse" name="searchAskResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteGive">
//
//	         <wsdl:input message="impl:deleteGiveRequest" name="deleteGiveRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:deleteGiveResponse" name="deleteGiveResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewAsk">
//
//	         <wsdl:input message="impl:viewAskRequest" name="viewAskRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:viewAskResponse" name="viewAskResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deactivateGive">
//
//	         <wsdl:input message="impl:deactivateGiveRequest" name="deactivateGiveRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:deactivateGiveResponse" name="deactivateGiveResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateGive">
//
//	         <wsdl:input message="impl:updateGiveRequest" name="updateGiveRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:updateGiveResponse" name="updateGiveResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getAllAsks">
//
//	         <wsdl:input message="impl:getAllAsksRequest" name="getAllAsksRequest">
//
//	       </wsdl:input>
//
//	         <wsdl:output message="impl:getAllAsksResponse" name="getAllAsksResponse">
//
//	       </wsdl:output>
//
//	      </wsdl:operation>
//
//	   </wsdl:portType>
//
//	   <wsdl:binding name="RestFul_Controller_BNSoapBinding" type="impl:RestFul_Controller_BN">
//
//	      <wsdlsoap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
//
//	      <wsdl:operation name="getAllGives">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getAllGivesRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getAllGivesResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createThank">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="createThankRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="createThankResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchGive">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="searchGiveRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="searchGiveResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getMyGives">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getMyGivesRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getMyGivesResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewGive">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="viewGiveRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="viewGiveResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getAllThanks">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getAllThanksRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getAllThanksResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewThank">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="viewThankRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="viewThankResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getMyThanks">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getMyThanksRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getMyThanksResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateThank">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="updateThankRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="updateThankResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewThanksForUser">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="viewThanksForUserRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="viewThanksForUserResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchThanks">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="searchThanksRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="searchThanksResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewNote">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="viewNoteRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="viewNoteResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createNote">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="createNoteRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="createNoteResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteNote">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="deleteNoteRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="deleteNoteResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateNote">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="updateNoteRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="updateNoteResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchNote">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="searchNoteRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="searchNoteResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createAccount">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="createAccountRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="createAccountResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteAccount">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="deleteAccountRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="deleteAccountResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="activateAccount">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="activateAccountRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="activateAccountResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateAccount">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="updateAccountRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="updateAccountResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getAllAccounts">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getAllAccountsRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getAllAccountsResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewAccount">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="viewAccountRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="viewAccountResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateAsk">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="updateAskRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="updateAskResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createAsk">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="createAskRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="createAskResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteAsk">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="deleteAskRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="deleteAskResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deactivateAsk">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="deactivateAskRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="deactivateAskResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getMyAsks">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getMyAsksRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getMyAsksResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchAccount">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="searchAccountRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="searchAccountResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="createGive">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="createGiveRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="createGiveResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="searchAsk">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="searchAskRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="searchAskResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deleteGive">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="deleteGiveRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="deleteGiveResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="viewAsk">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="viewAskRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="viewAskResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="deactivateGive">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="deactivateGiveRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="deactivateGiveResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="updateGive">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="updateGiveRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="updateGiveResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	      <wsdl:operation name="getAllAsks">
//
//	         <wsdlsoap:operation soapAction=""/>
//
//	         <wsdl:input name="getAllAsksRequest">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:input>
//
//	         <wsdl:output name="getAllAsksResponse">
//
//	            <wsdlsoap:body use="literal"/>
//
//	         </wsdl:output>
//
//	      </wsdl:operation>
//
//	   </wsdl:binding>
//
//	   <wsdl:service name="RestFul_Controller_BNService">
//
//	      <wsdl:port binding="impl:RestFul_Controller_BNSoapBinding" name="RestFul_Controller_BN">
//
//	         <wsdlsoap:address location="http://localhost:8080/bn"/>
//
//	      </wsdl:port>
//
//	   </wsdl:service>
//
//	</wsdl:definitions>
//
//}
