class EventEmitter {
    map = new Map();
    subscribe(event, cb) {
        if (!this.map.has(event))
            this.map.set(event, [cb]);
        else {
            let arr = this.map.get(event);
            arr.push(cb);
            this.map.set(event, arr);
        }
        return {
            unsubscribe: () => {
                let arr = this.map.get(event);
                let pos = arr.findIndex(cb);   
                arr.splice(pos,1);
                this.map.set(event,arr);  
            }
        };
    }

  emit(event, args = []) {
      if (!this.map.has(event)) {
          return [];
      }
      else {
          let arr = this.map.get(event);
          return arr.map((fn) => {
              return fn(...args);
          });
      }
  }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */