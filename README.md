kartEst - Projecto Kartodromo  
=============================

###Aluguer de Karts  
A Associação de Estudantes da EST, com a colaboração da Direcção, decidiu fazer do estacionamento da EST uma pista de Karts, aos fins de semana. Para gerir o aluguer dos karts a Associação pediu aos alunos de Programação III que desenvolvessem uma aplicação para o efeito. Neste momento o software está em fase de desenvolvimento e o seu contributo será essencial para a sua conclusão.  

###Processo de Aluguer  
Para alugar um kart, o cliente tem duas hipóteses: ou é um piloto registado ou faz o aluguer apenas no momento. Os pilotos que se registem terão vantagens como se verá mais à frente.  
Para alugar será necessário introduzir o número de piloto, de modo a identificar o piloto. Para os pilotos não registados está reservado o número 0.  
O piloto terá de seguida solicitar o número de voltas que pretende alugar e será calculado o custo do aluguer para que o cliente indique se deseja proceder com o aluguer ou desistir.  
O passo seguinte consiste em escolher, de entre os karts disponíveis, o kart a utilizar. Depois é só dirigir-se para as boxes, sentar-se no kart escolhido e correr. Ao fim das voltas acordadas o cliente retorna às boxes e termina o aluguer.  

###Registo de Pilotos  
Cada cliente pode escolher registar-se para assim usufruir de algumas vantagens. O kartódromo permite o registo do cliente como: piloto cronometrado, piloto regular e piloto frequente.

*Piloto Cronometrado*  
Este piloto tem direito a uma listagem com os tempos das voltas no final do aluguer. Para isso o sistema regista os vários tempos. No entanto o sistema não guarda os tempos entre os diversos alugueres, ou seja, no próximo aluguer os tempos anteriores são perdidos. O único tempo que se guarda sempre é a melhor volta. Tem de pagar a taxa de cronometragem em cada aluguer.

*Piloto Regular*  
Este piloto tem direito a uma listagem com os tempos das voltas no final do aluguer. O sistema guarda os tempos entre os diversos alugueres dentro do mesmo mês. O único tempo que se guarda sempre é a melhor volta.  
Não tem de pagar a taxa de cronometragem e tem direito a duas voltas grátis em cada aluguer por cada grupo de 10 solicitadas (por exemplo se pedir 10 voltas só paga 8, se pedir 23 voltas só paga 19). Tem de pagar uma taxa mensal no primeiro aluguer do mês.

*Piloto Frequente*  
Este piloto tem direito a uma listagem com os tempos das voltas no final do aluguer e o sistema guarda permanentemente todos os seus tempos. Não tem de pagar a taxa de cronometragem e tem direito a 200 voltas grátis por mês. Acima desse valor paga o preço normal por volta. Tem de pagar a taxa mensal no primeiro aluguer do mês.  

###Interface da aplicação  
A interface neste momento ainda é feita em modo de texto e compreende apenas duas janelas muito simples. Uma das janelas corresponde ao menu de gestão e a outra ao écran que monitoriza os tempos realizados pelos pilotos.  

###Interface de Gestão  
Nesta interface o operador tem as seguintes opções:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; P - criar novo Piloto  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; A - novo Aluguer  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; K - ver Karts alugados  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; V - Ver piloto  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; F - Fechar mês  

*Criar novo piloto*: Nesta opçao é solicitado o nome do piloto e o tipo de piloto registado que quer ser. A cada piloto é atribuído um número único, pelo sistema, que o identificará.  

*Novo Aluguer*: Nesta opçao é solicitado o número do piloto que faz o aluguer. Para indicar que se trata de um piloto não registado é usado o número 0. Depois é solicitado o número de voltas a alugar. O preço é apresentado e o piloto confirma o aluguer. Depois apresenta-se uma listagem dos karts disponíveis para que o piloto escolha o que deseja. O aluguer é então iniciado alocando o kart ao piloto.  
Notas: no primeiro aluguer do mês de um piloto regular, ou frequente, este terá de pagar o valor da taxa mensal.  

*Ver karts alugados*: É apresentado o número de karts alugados no momento. Para cada kart alugado é apresentada a informação do seu número, o nome do piloto, as voltas alugadas e as voltas dadas.  

*Ver piloto*: Começa-se por pedir o número do piloto a visualizar. Depois são apresentados o nome, o registo da melhor volta e os tempos que o sistema tem registados sobre o piloto.  
Notas: o melhor tempo para um piloto não registado é sempre 999,999; Para pilotos cronometrados são apresentados os tempos do último aluguer, para pilotos regulares são apresentados os tempos do mês corrente, para os pilotos frequentes são mostrados os tempos todos que já fez.  

*Fechar mês*: Esta opção destina-se a fechar o mês. Por exemplo, nos pilotos regulares, os tempos são limpos e as taxas mensais são dadas como não pagas.  

###Interface de tempos  
Nesta interface aparecem os tempos dos vários karts que estão alugados. Neste momento ainda se está a desenvoler o sistema de cronometragem pelo que esta parte será simulada com o recurso a um gerador aleatório de tempos. Para cada kart será apresentada uma linha com o tempo que efectuou por volta.  

*Outros pormenores*  
- Os tempos devem ser todos em segundos.  
- As interfaces já estão começadas, mas terão de ser completadas.  
- A parte de geração dos tempos está feita.  
- Para cada registo de tempo deve ser apresentado o número do kart e o tempo da volta.  
- A tabela de preços está em anexo. O programa deve estar feito de modo a garantir que se os preços se alterarem não é necessário alterar o código do mesmo. Os preços estão em euros.  

###Objectivos  
O Objectivo deste trabalho é implementar o sistema tal como está descrito, dando-se especial atenção à correcta implementação da arquitectura do sistema e às características referidas no desenvolvimento de software.  

**Tabela de Preços**  
&nbsp;&nbsp;&nbsp; 1 Volta - 1 €  
*Piloto cronometrado*  
&nbsp;&nbsp;&nbsp; +1€ por aluguer para cronometrar  
*Piloto Regular*  
&nbsp;&nbsp;&nbsp; mensalidade de 10€;  
&nbsp;&nbsp;&nbsp; 2 voltas grátis em cada grupo completo de 10 num aluguer  
*Piloto Frequente*  
&nbsp;&nbsp;&nbsp; mensalidade de 130€;  
&nbsp;&nbsp;&nbsp; 200 voltas gratuitas por mês  
