package apps.refactoring_project.fowler_2019.pojo;

import apps.refactoring_project.fowler_2019.db.dto.PlayDTO;

public class Play {

    String name;
    String type;

    public Play(PlayDTO playDTO) {
        this.name = playDTO.getName();
        this.type = playDTO.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
