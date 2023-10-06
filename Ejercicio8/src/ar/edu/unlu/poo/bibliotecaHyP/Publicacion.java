package ar.edu.unlu.poo.bibliotecaHyP;

public class Publicacion {
    private String editor = "";
    private String anioPublicacion = "";
    private String telefonoProveedor = "";
    private String nombre = "";
    private Integer paginas = 0;
    private Integer cantidadEjemplares = 0;
    private Integer cantidadPrestados = 0;


    public Publicacion(String editor, String anioPublicacion, String telefonoProveedor, String nombre, Integer paginas, Integer cantidadEjemplares) {
        this.setEditor(editor);
        this.setAnioPublicacion(anioPublicacion);
        this.setTelefonoProveedor(telefonoProveedor);
        this.setNombre(nombre);
        this.setPaginas(paginas);
        this.setCantidadEjemplares(cantidadEjemplares);
    }

    public Publicacion(String nombre, int cantidadEjemplaresIniciales, int cantidadPaginas) {
        this.setNombre(nombre);
        this.setPaginas(cantidadPaginas);
        this.setCantidadEjemplares(cantidadEjemplaresIniciales);
    }

    //Geteres
    public String getEditor() {
        return editor;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public Integer getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public Integer getCantidadPrestados() {
        return cantidadPrestados;
    }

    //Seteres
    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        if (cantidadEjemplares > cantidadPrestados){
            this.cantidadEjemplares = cantidadEjemplares;
        }
    }

    public void setCantidadPrestados(Integer cantidadPrestados) {
        this.cantidadPrestados = cantidadPrestados;
    }

    //Metodos
    public boolean prestarEjemplar() {
        if (this.cantidadPrestados + 1 < this.cantidadEjemplares) {
            cantidadPrestados++;
            return true;
        } else
            return false;
    }

    public boolean devolverEjemplar() {
        if (this.cantidadPrestados > 0) {
            cantidadPrestados--;
            return true;
        } else
            return false;
    }


    public int getCantidadDisponible() {
        return this.cantidadEjemplares - this.getCantidadPrestados();
    }
    @Override
    public String toString() {
        return  "editor=" + editor +
                "nombre='" + nombre + '\'' +
                ", paginas=" + paginas +
                ", cantidadEjemplares=" + cantidadEjemplares +
                ", cantidadPrestados=" + cantidadPrestados;
    }
}
