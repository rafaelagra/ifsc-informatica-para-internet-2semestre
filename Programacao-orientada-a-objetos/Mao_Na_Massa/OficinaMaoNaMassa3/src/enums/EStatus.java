package enums;

/*
* este enum representa os estados possíveis de uma ordem de serviço
* uma OS pode estar aberta (em andamento), fechada (concluída) ou cancelada
* */
public enum EStatus {
    ABERTA, // quando a OS acabou de ser criada, serviços ainda podem ser adicionados/removidos
    FECHADA, // quando a OS já foi finalizada e faturada
    CANCELADA // quando a OS foi cancelada (não gera cobrança)
}
