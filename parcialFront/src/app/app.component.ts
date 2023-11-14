import {Component, OnInit} from '@angular/core';
import {EquipoService} from "./services/equipo.service";
import {Equipo} from "./model/equipo.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  equipos : Equipo[] = []
  equipoCreado: Equipo

  constructor(private equipoService : EquipoService) {
    this.equipoCreado = new Equipo('', '', 0);
  }

  ngOnInit() {
    this.equipoService.getEquipos().subscribe((res) => {
      this.equipos = res
    })
  }

  onSubmit() {
    this.equipos.push(this.equipoCreado)
    this.equipoService.crearEquipo(this.equipoCreado)
    this.equipoCreado = new Equipo('', '', 0);
  }
}
