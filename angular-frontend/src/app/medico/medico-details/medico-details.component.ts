import { Component, OnInit } from '@angular/core';
import { Medico } from '../../medico';
import { ActivatedRoute } from '@angular/router';
import { MedicoService } from '../../medico.service';

@Component({
  selector: 'app-medico-details',
  templateUrl: './medico-details.component.html',
  styleUrls: ['./medico-details.component.css']
})
export class MedicoDetailsComponent implements OnInit {

  id: number
  medico: Medico
  constructor(public route: ActivatedRoute, public employeService: MedicoService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.medico = new Medico();
    this.employeService.getMedicoById(this.id).subscribe( data => {
      this.medico = data;
    });
  }

}
