class Particion {
    private int size;
    private String proceso;

    public Particion(int size){
        this.size = size;
        this.proceso = null;
    }

    //Retornara el taman de la particion 
    public int getSize() {
        return size;
    }

    //Retorna el nombre del proceso asignado, si existe
    public String getProceso() {
        return proceso;
    }
    //Retorna el nombre del proceso asignado, si existe....
    public boolean isfree(){
        return proceso == null;
    }
    
    public boolean asgnar_Proceso(String Nombre_Proceso, int proceso_Size){
        if (isfree() && proceso_Size <= size) {
            this.proceso = Nombre_Proceso;
            return true;
        }
        return false;
    }

    public void free_Particion(){
        this.proceso = null;
    }
}
