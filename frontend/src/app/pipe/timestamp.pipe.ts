import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'timestamp'})
export class TimestampPipe implements PipeTransform {
    transform(value: number): string {
        if (!value) {
            return '';
        }
        return TransformTimestamp(value);
    }
}

export function TransformTimestamp(ts: number): string {
    const d = new Date(ts);
    const year = d.getFullYear();
    const month = normalizeTimeValue(d.getMonth() + 1);
    const day = normalizeTimeValue(d.getDate());
    const hour = normalizeTimeValue(d.getHours());
    const min = normalizeTimeValue(d.getMinutes());
    const sec = normalizeTimeValue(d.getSeconds());

    return `${year}/${month}/${day} ${hour}:${min}:${sec}`;
}

function normalizeTimeValue(value: number): string {
    if (value >= 10) {
        return '' + value;
    }

    return `0${value}`;
}
