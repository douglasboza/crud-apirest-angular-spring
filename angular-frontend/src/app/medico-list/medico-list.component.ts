import { Component, OnInit } from '@angular/core';
import { Medico } from '../medico'
import { MedicoService } from '../medico.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-medico-list',
  templateUrl: './medico-list.component.html',
  styleUrls: ['./medico-list.component.css']
})
export class MedicoListComponent implements OnInit {

  medicos: Medico[];

  constructor(private medicoService: MedicoService,
    private router: Router) { }

  ngOnInit(): void {
    this.getMedicos();
  }

  private getMedicos(){
    this.medicoService.getMedicosList().subscribe(data => {
      this.medicos = data;
    });
  }

  medicoDetails(id: number){
    this.router.navigate(['medico-details', id]);
  }

  updateMedico(id: number){
    this.router.navigate(['update-medico', id]);
  }

  deleteMedico(id: number){
    this.medicoService.deleteMedico(id).subscribe( data => {
      console.log(data);
      this.getMedicos();
    })
  }
}
