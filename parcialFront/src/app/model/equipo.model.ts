export class Equipo {
  nombre: string
  ciudad: string
  copasInternacionales: number

  constructor(nombre: string, ciudad: string, copasInternacionales: number) {
    this.nombre = nombre
    this.ciudad = ciudad
    this.copasInternacionales = copasInternacionales
  }
}
