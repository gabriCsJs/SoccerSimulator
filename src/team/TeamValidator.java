package team;

import people.Person;
import people.Player;
import team.customExceptions.PersonBelongsToThisTeamException;
import team.customExceptions.PersonDoNotBelongsToThisTeamException;
import team.customExceptions.PlayerEstaNoElencoException;
import team.customExceptions.PlayerNaoEstaNoElencoException;

public final class TeamValidator {

    private TeamValidator() {
        throw new UnsupportedOperationException("Classe utilitária de validação.");
    }


    public static void validarSePessoaAtuaNoClube(Person person, Team team) {
        if (!person.getCurrentTeam().equals(team)) {
            throw new PersonDoNotBelongsToThisTeamException();
        }
    }

    // Antigo pertenceAEsseTime com ResultadoEsperado = false
    public static void validarSePessoaNaoAtuaNoClube(Person person, Team team) {
        if (person.getCurrentTeam().equals(team)) {
            throw new PersonBelongsToThisTeamException();
        }
    }

    public static void validarSeJogadorExistenoElenco(Player player, Team team) {
        if(!team.getElenco().contains(player.getName())){
            throw new PlayerNaoEstaNoElencoException();
        }
    }

    public static void validarSeJogadorNaoEstaNoElenco(Player player,Team team) {
        if(team.getElenco().contains(player.getName())){
            throw new PlayerEstaNoElencoException();
        }
    }


}
