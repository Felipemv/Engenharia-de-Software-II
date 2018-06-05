/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.enums.EAffiliate;
import br.carmaker.model.enums.EMenuItem;

/**
 * A classe centraliza todas as mensagens e constantes utilizadas no software.
 * O nome das mensagens seguem o seguinte padrão: 1_2_3
 * 1 = Finalidade ou resultado obtido
 * 2 = Atividade que está relacionada ou o CRUD relacionado
 * 3 = Entidade/Sistema
 * @author felipe
 */
public abstract class JConstants {

//    Mensagens de confirmação, resultado: 
//    O nome das seguintes mensagens seguem o seguinte padrão: 1_2_3
//    * 1 = Finalidade ou resultado obtido
//    * 2 = Atividade que está relacionada ou o CRUD relacionado
//    * 3* = Entidade/Sistema
    
    public static final String SUCCESS_CREATE_EMPLOYEE = "Funcionário criado com sucesso!";
    public static final String SUCCESS_CREATE_CAR = "Carro criado com sucesso!";
    public static final String SUCCESS_CREATE_FEEDSTOCK = "Matéria-prima criada com sucesso!";
    public static final String SUCCESS_CREATE_SUPPLIER = "Fornecedor criado com sucesso!";
    public static final String SUCCESS_CREATE_DEALERSHIP = "Concessionária criada com sucesso!";
    public static final String SUCCESS_CREATE_SHIPPING_COMPANY = "Transportadora criada com sucesso!";
    public static final String SUCCESS_CREATE_ORDER = "Pedido criado com sucesso!";
    
    public static final String FAILURE_CREATE_EMPLOYEE = "Falha ao criar funcionário!";
    public static final String FAILURE_CREATE_CAR = "Falha ao criar funcionário!";
    public static final String FAILURE_CREATE_FEEDSTOCK = "Falha ao criar matéria-prima!";
    public static final String FAILURE_CREATE_SUPPLIER = "Falha ao criar fornecedor!";
    public static final String FAILURE_CREATE_DEALERSHIP = "Falha ao criar concessionária!";
    public static final String FAILURE_CREATE_SHIPPING_COMPANY = "Falha ao criar transportadora!";
    public static final String FAILURE_CREATE_ORDER = "Falha ao criar pedido!";
    
    public static final String SUCCESS_EDIT_EMPLOYEE = "Funcionário editado com sucesso!";
    public static final String SUCCESS_EDIT_CAR = "Carro editado com sucesso!";
    public static final String SUCCESS_EDIT_FEEDSTOCK = "Matéria-prima editada com sucesso!";
    public static final String SUCCESS_EDIT_SUPPLIER = "Fornecedor editado com sucesso!";
    public static final String SUCCESS_EDIT_DEALERSHIP = "Concessionária editada com sucesso!";
    public static final String SUCCESS_EDIT_SHIPPING_COMPANY = "Transportadora editada com sucesso!";
    public static final String SUCCESS_EDIT_ORDER = "Pedido editado com sucesso!";
    
    public static final String FAILURE_EDIT_EMPLOYEE = "Falha ao editar funcionário!";
    public static final String FAILURE_EDIT_CAR = "Falha ao editar carro!";
    public static final String FAILURE_EDIT_FEEDSTOCK = "Falha ao editar matéria-prima!";
    public static final String FAILURE_EDIT_SUPPLIER = "Falha ao editar fornecedor!";
    public static final String FAILURE_EDIT_DEALERSHIP = "Falha ao editar concessionária!";
    public static final String FAILURE_EDIT_SHIPPING_COMPANY = "Falha ao editar transportadora!";
    public static final String FAILURE_EDIT_ORDER = "Falha ao editar pedido!";
    
    public static final String SUCCESS_DELETE_EMPLOYEE = "Funcionário deletado com sucesso!";
    public static final String SUCCESS_DELETE_CAR = "Carro deletado com sucesso!";
    public static final String SUCCESS_DELETE_FEEDSTOCK = "Matéria-prima deletada com sucesso!";
    public static final String SUCCESS_DELETE_SUPPLIER = "Fornecedor deletado com sucesso!";
    public static final String SUCCESS_DELETE_DEALERSHIP = "Concessionária deletada com sucesso!";
    public static final String SUCCESS_DELETE_SHIPPING_COMPANY = "Transportadora deletada com sucesso!";
    public static final String SUCCESS_DELETE_ORDER = "Pedido deletado com sucesso!";
    
    public static final String FAILURE_DELETE_EMPLOYEE = "Falha ao deletar funcionário!";
    public static final String FAILURE_DELETE_CAR = "Falha ao deletar carro!";
    public static final String FAILURE_DELETE_FEEDSTOCK = "Falha ao deletar matéria-prima!";
    public static final String FAILURE_DELETE_SUPPLIER = "Falha ao deletar fornecedor!";
    public static final String FAILURE_DELETE_DEALERSHIP = "Falha ao deletar concessionária!";
    public static final String FAILURE_DELETE_SHIPPING_COMPANY = "Falha ao deletar transportadora!"; 
    public static final String FAILURE_DELETE_ORDER = "Falha ao deletar pedido!"; 
    
    public static final String CONFIRM_DELETE_EMPLOYEE = "Confirmar exclusão do funcionário?";
    public static final String CONFIRM_DELETE_CAR = "Confirmar exclusão do carro?";
    public static final String CONFIRM_DELETE_FEEDSTOCK = "Confirmar exclusão da matéria-prima?";
    public static final String CONFIRM_DELETE_SUPPLIER = "Confirmar exclusão do fornecedor?";
    public static final String CONFIRM_DELETE_DEALERSHIP = "Confirmar exclusão da concessionária?";
    public static final String CONFIRM_DELETE_SHIPPING_COMPANY = "Confirmar exclusão da transportadora?";
    public static final String CONFIRM_DELETE_ORDER = "Confirmar exclusão do pedido?";
    
    public static final String CONFIRM_EDIT_EMPLOYEE = "Confirmar edição do funcionário?";
    public static final String CONFIRM_EDIT_CAR = "Confirmar edição do carro?";
    public static final String CONFIRM_EDIT_FEEDSTOCK = "Confirmar edição da matéria-prima?";
    public static final String CONFIRM_EDIT_SUPPLIER = "Confirmar edição do fornecedor?";
    public static final String CONFIRM_EDIT_DEALERSHIP = "Confirmar edição da concessionária?";
    public static final String CONFIRM_EDIT_SHIPPING_COMPANY = "Confirmar edição da transportadora?";
    public static final String CONFIRM_EDIT_ORDER = "Confirmar edição do pedido?";
    
//    Mensagens do sistema
//    O nome das seguintes mensagens seguem o seguinte padrão: 1_2_3
//    * 1 = Componente
//    * 2* = Mensagem
    
    public static final String LABEL_RESTART_SYSTEM = "Você alterou o próprio cadastro, reinicie o sistema para que seus dados sejam atualizados.";
    public static final String LABEL_CONFIRM_LOGOUT = "Confirmar Saída do Sistema?";
    public static final String BUTTON_RESTART_SYSTEM = "Reiniciar Sistema";
    
    public static final String LABEL_ALL_FIELDS_REQUIRED = "Todos os campos são obrigatórios!";
    public static final String LABEL_DIFFERENT_EMAILS = "Os emails assinalados são diferentes!";
    public static final String LABEL_DIFFERENT_PASSWORDS = "As senhas assinaladas são diferentes!";
    public static final String LABEL_REGISTER_EXISTS = "Número de registro já foi utilizado.";
    public static final String LABEL_CANT_DELETE_OWN_USER = "Você não pode deletar seu próprio usuário do sistema.";
    public static final String LABEL_NEED_ONE_SUPPLIER = "Você precisa adicionar no mínimo um fornecedor.";
    public static final String LABEL_NO_ITEM_SELECTED = "Ops! Nenhum item foi selecionado!";
    public static final String LABEL_NO_ORDER_SELECTED = "Ops! Nenhum tipo de pedido foi selecionado!";
    public static final String LABEL_NO_AFFILIATE_SELECTED = "Ops! Nenhuma afiliada selecionada!";
    public static final String LABEL_OK = "OK";
    public static final String LABEL_YES = "Sim";
    public static final String LABEL_NO = "Não";
    public static final String LABEL_TWO_SUPPLIERS_ONLY = "São permitidos somente dois fornecedores para cada matéria prima.";
    
//    Mensagens gerais
    public static final String DEFAULT_USER_IMAGE = "/image/user_default.png";
    public static final String DEFAULT_CHOOSER_IMAGE_LOCATION = "C:\\Users\\Usuário\\Desktop";
    public static final String NAME = "Nome";
    public static final String ADDRESS = "Endereço";
    public static final String CNPJ = "Cnpj";
    public static final String LEAD_TIME = "Lead Time";
    public static final String AMOUNT = "Quantidade";
    public static final String FLEET = "Frota";
    public static final String TYPE = "Tipo";
    public static final String PROTOCOL = "Protocolo";
    public static final String FEEDSTOCK = "Matéria-prima";
    public static final String SUPPLIER = "Fornecedor";
    public static final String STATUS = "Status";
    public static final String DATE = "Data";
    public static final String SHIPPING_COMPANY = "Transportadora";
    public static final String DEALERSHIP = "Concessionária";
    public static final String CAR = "Carro";
    public static String DATE_FORMAT = "dd/MM/yyyy";
    
}
