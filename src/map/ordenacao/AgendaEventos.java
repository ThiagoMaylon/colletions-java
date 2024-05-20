package map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    Map<LocalDate, Evento> eventoMap;

    public AgendaEventos(){
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventoMap.put(data, new Evento(data, nome, atracao));
    }
    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosOrdenados = new TreeMap<>(eventoMap);
        if(!eventosOrdenados.isEmpty()){
            for(Evento evento : eventosOrdenados.values()){
                System.out.println("Data: " + evento.getData() + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
            }
        }else{
            System.out.println("nenhum evento foi encontrado");
        }
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Evento proximoEvento = null;
        for(Map.Entry<LocalDate, Evento> map : eventoMap.entrySet()){
            if(map.getValue().getData().equals(dataAtual) || map.getValue().getData().isAfter(dataAtual)){
                proximoEvento = map.getValue();
            }
        }
        if(proximoEvento != null){
            System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximoEvento.getData());
        }else{
            System.out.println("Não há eventos futuros na agenda.");
        }
    }

    public static void main(String[] args){
        AgendaEventos agendaEventos = new AgendaEventos();

        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2020, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirAgenda();

        // Obtém e exibe o próximo evento na agenda
        agendaEventos.obterProximoEvento();
    }
}
